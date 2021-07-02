package cn.ainannan.commons.async;

import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import cn.ainannan.timeline.picManager.mapper.TimelineSimilarMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class AsyncUtil {
    
    @Autowired
    AsyncServiceImpl asyncTestService;
    @Autowired
    private TimelinePicMapper picMapper;
    @Autowired(required = false)
    private TimelineSimilarMapper similarMapper;

    private static final Float SIMILAR_MIN_SIZE = 90F;
    private static List<TimelinePic> picList2 = null;

    public static Integer [] ides = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,
            15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};


    // @Scheduled(cron = "0 */1 * * * ?")
    public void test(){
        int size = ides.length / 4 + 1;
        List<Integer> ints = Arrays.asList(ides);
        for (int i = 1; i <= 4; i++) {
            int s = i * size - size;
            int e = i * size;
            if(e > ides.length) e = ides.length;
            asyncTestService.test(ints.subList(s, e));
        }
    }

    private static final Integer XIANCHENG_NUM = 4;

    @PostConstruct
    // @Scheduled(cron = "0 */1 * * * ?")
    public void compute(){
        // 数据定义区
        List<Integer> endFlagList = Lists.newArrayList(); // 测试传入参数的
        int size = 0;

        endFlagList.add(0);

        // 获取原始数据
        List<TimelinePic> picList = getPicList();
        System.out.println("picList.size() = " + picList.size());

        size = picList.size() / XIANCHENG_NUM + 1;

        for (int i = 1; i <= XIANCHENG_NUM; i++) {
            int s = i * size - size;
            int e = i * size;
            if(e > picList.size()) e = picList.size();
            asyncTestService.computeFinger(picList.subList(s, e), endFlagList);
        }

        while(endFlagList.get(0) < XIANCHENG_NUM){
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("main -- endFlag = " + endFlagList.get(0));

    }

    public List<TimelinePic> getPicList(){

        // 调取整个表，循环判断，并存储

        TimelinePic query = new TimelinePic();
        query.setSimilarStatus(0);
        query.setLimitNum(50);

        // PageHelper.startPage(1, 10);
        List<TimelinePic> picList = picMapper.findListFor1000(query);

        if(picList == null || picList.size() == 0) return null;

        return picList;
    }
}
