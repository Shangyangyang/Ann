package cn.ainannan.sys.test.duoxiancheng;

import java.util.concurrent.*;

public class DingshiThread {

    public static void main(String[] args) throws Exception {


        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);

        ScheduledFuture sf = ses.schedule(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("执行");
                return "Called!!";
            }
        }, 5, TimeUnit.SECONDS);

        System.out.println("sf.get() = " + sf.get());

        ses.shutdown();
        
    }
}
