package cn.ainannan.commons.async;

import cn.ainannan.commons.utils.StringUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.bean.TimelineSimilar;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import cn.ainannan.timeline.picManager.mapper.TimelineSimilarMapper;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

@Service
public class AsyncServiceImpl {

    private static Logger logger = LogManager.getLogger(AsyncServiceImpl.class.getName());
    public static final Float SIMILAR_MIN_SIZE = 90F;

    @Autowired
    private TimelinePicMapper picMapper;
    //    @Autowired(required = false)
    private TimelineSimilarMapper similarMapper;
    @Autowired
    private SqlSessionFactory ssf;


    @Async
    public void computeFinger(List<TimelinePic> picList, CountDownLatch latch) {
        SqlSession sqlSession = ssf.openSession();
        similarMapper = sqlSession.getMapper(TimelineSimilarMapper.class);

        System.out.println(Thread.currentThread().getName() + " 开始执行");

        TimelineSimilar ts = null; // 最终要保存的实例，每次循环都会被覆盖
        List<TimelineSimilar> tsList; // 用来比对新发现的数据是否已存在的List
        List<TimelineSimilar> saveList = Lists.newArrayList();  // 要保存的指纹List
        List<TimelinePic> tpList = Lists.newArrayList();    // 要保存的图片list

        /*
        初始化
         */
        synchronized (Object.class) {
            tsList = similarMapper.findList(new TimelineSimilar());
        }

        int count = 0;          // 进度条统计 总数
        int computeNum = 0;     // 进度条统计 已计算的指纹数量
        int computeNumOld = 0;     // 进度条统计 已计算的指纹数量
        int tempForNum = 0;     // 进度条统计 已计算的指纹数量

        for (TimelinePic p1 : picList) {
            Long curTime2 = new Date().getTime();   // 进度条统计 当前时间

            // 为节省数据库资源，如果没有新发现时，不执行查询。
            if (computeNum != computeNumOld) {

                // 获取一遍最新的指纹列表
                synchronized (Object.class) {
                    tsList = similarMapper.findList(new TimelineSimilar());
                    computeNumOld = computeNum;
                }
            }

            int tempForNum2 = 0;     // 进度条统计 已计算的指纹数量

            // 循环
            for (TimelinePic p2 : AsyncUtil.picList2) {

                // 如果两条数据不是相同ID，并且指纹都不为空
                if (!p1.getShortId().equals(p2.getShortId())
                        && p1.getFingerPrint() != null
                        && p2.getFingerPrint() != null) {


                    // 计算相似度
                    float similar = 0F;

                    similar = StringUtils.getSimilarityRatio(p1.getFingerPrint(), p2.getFingerPrint());

                    // 如果相似度达到指定值，则进行保存操作
                    if (similar >= SIMILAR_MIN_SIZE) {

                        ts = new TimelineSimilar();
                        ts.setPicid(p1.getShortId());
                        ts.setOtherid(p2.getShortId());
                        ts.setSimilarity(similar);
                        ts.setType(1);
                        // 这里做数据库是否存在的判断
                        Optional<TimelineSimilar> temp = tsList.stream()
                                .filter(item ->
                                        (
                                                item.getPicid().equals(p1.getShortId()) &&
                                                        item.getOtherid().equals(p2.getShortId())
                                        ) ||
                                                (
                                                        item.getPicid().equals(p2.getShortId()) &&
                                                                item.getOtherid().equals(p1.getShortId())
                                                )
                                ).findAny();
                        // 如果tsList里不存在，则进行保存操作。
                        if (!temp.isPresent()) {
                            synchronized (Object.class) {
                                saveList.add(ts);
                            }
                        }
                    }

                }
            }
            // 第一个大循环里，改变图片是否比对的状态，并保存。

            TimelinePic tp = new TimelinePic();
            tp.setId(p1.getId());
            tp.setSimilarStatus(1);

            synchronized (Object.class) {
                tpList.add(tp);
            }

            // 执行批量保存
            synchronized (Object.class) {
                if (saveList.size() > 0) {
                    similarMapper.insertSimilarByList(saveList);
                }

                computeNum += saveList.size();
                saveList = Lists.newArrayList();
            }
        }

        picMapper.updateByList(tpList);

        sqlSession.close(); // 一定要记得关闭数据库连接，因为这个数据库连接是自己创建的。
        System.out.println(Thread.currentThread().getName() + " 结束");
        latch.countDown();
    }

}























