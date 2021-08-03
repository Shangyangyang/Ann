package cn.ainannan.commons.async;

import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public class AsyncUtil {
    
    @Autowired
    AsyncServiceImpl asyncTestService;
    @Autowired
    private TimelinePicMapper picMapper;

    private static final Integer SELECT_MAX_NUM = 100;   // 读取图片最大条数
    private static final Integer XIANCHENG_NUM = 4;     // 线程数

    public static List<TimelinePic> picList2 = null;


    // @PostConstruct
    @Scheduled(cron = "0 */1 * * * ?")
    public void compute(){
        long sTime = new Date().getTime();
        // 数据定义区
        List<Integer> endFlagList = Lists.newArrayList(); // 测试传入参数的
        final CountDownLatch latch = new CountDownLatch(XIANCHENG_NUM);
        int size = 0;

        endFlagList.add(0);

        // 获取原始数据
        List<TimelinePic> picList = getPicList();

        if(picList == null || picList.size() <= 0) return;

        if(null == picList2) {
            picList2 = picMapper.findTempList2();
        }

        size = picList.size() / XIANCHENG_NUM + (picList.size() % XIANCHENG_NUM == 0 ? 0 : 1);

        for (int i = 1; i <= XIANCHENG_NUM; i++) {
            int s = i * size - size;
            int e = i * size;
            if(e > picList.size()) e = picList.size();
            asyncTestService.computeFinger(picList.subList(s, e), latch);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("子线程都执行完毕，继续执行主线程，总耗时： "
                + ((new Date().getTime() - sTime) / 1000) + " 秒。");

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public List<TimelinePic> getPicList(){

        // 调取整个表，循环判断，并存储

        TimelinePic query = new TimelinePic();
        query.setSimilarStatus(0);
        query.setLimitNum(SELECT_MAX_NUM);

        // PageHelper.startPage(1, 10);
        List<TimelinePic> picList = picMapper.findListFor1000(query);

        if(picList == null || picList.size() == 0) return null;

        return picList;
    }
}
