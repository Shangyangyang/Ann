package cn.ainannan.sys.test;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTest {

    //@Scheduled(cron = "*/5 * * * * ?")
    public void test1() throws InterruptedException {
        System.out.println("test1: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        Thread.sleep(3000L);
    }

    //@Scheduled(cron = "*/5 * * * * ?")
    public void test2() throws InterruptedException {
        System.out.println("test2: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        Thread.sleep(3000L);
    }

    //@Scheduled(cron = "*/5 * * * * ?")
    public void test3() throws InterruptedException {
        System.out.println("test3: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        Thread.sleep(3000L);
    }

    //@Scheduled(cron = "*/5 * * * * ?")
    public void test4() throws InterruptedException {
        System.out.println("test4: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));        Thread.sleep(2000L);
        Thread.sleep(3000L);
    }
}
