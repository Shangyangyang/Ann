package cn.ainannan.sys.test.duoxiancheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Xianchengchi {
    public static void main(String[] args) {
        /*
        线程池的用法，固定长度。
         */
        ExecutorService es = Executors.newFixedThreadPool(2);

        Thread t1 = new XianchengchiMyThread();
        Thread t2 = new XianchengchiMyThread();
        Thread t3 = new XianchengchiMyThread();
        Thread t4 = new XianchengchiMyThread();
        Thread t5 = new XianchengchiMyThread();

        es.execute(t1);
        es.execute(t2);
        es.execute(t3);
        es.execute(t4);
        es.execute(t5);

        es.shutdown();

    }

}

class XianchengchiMyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行....");
    }
}
