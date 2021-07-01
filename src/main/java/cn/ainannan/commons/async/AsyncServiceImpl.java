package cn.ainannan.commons.async;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AsyncServiceImpl /*implements AsyncTestService */{
    private static Logger logger = LogManager.getLogger(AsyncServiceImpl.class.getName());

    @Async
    public void test(List<Integer> ints) {
        System.out.println("ints = " + ints);
        ints.stream().forEach(item -> {
            try{
                Thread.sleep(((new Random().nextInt(10) + 1) * 500));
            }catch (Exception e){

            }
            logger.info("线程-" + Thread.currentThread().getName() + "在执行写入: item = " + item);
        });
    }

}























