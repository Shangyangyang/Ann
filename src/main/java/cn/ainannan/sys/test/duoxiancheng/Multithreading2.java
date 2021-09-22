package cn.ainannan.sys.test.duoxiancheng;

import java.util.concurrent.*;

public class Multithreading2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        method2();
    }

    public static void method2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Callable(){
            public Object call() throws Exception {
                System.out.println("Asynchronous Callable");
                return "Callable Result";
            }
        });
        System.out.println("future.get() = " + future.get());
        executorService.shutdown();
    }

    public static void method1(){
        ShareData2 shareData = new ShareData2();
        for (int i = 0; i < 8; i++) {

            if(i % 2 == 0) {
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            shareData.inc();
                        }
                    }
                }, "xiancheng_"+i).start();
            } else {
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            shareData.dec();
                        }
                    }
                }, "xiancheng_"+i).start();
            }
        }
    }
}

class RunnableShareInc2 implements Runnable{
    private ShareData shareData;

    public RunnableShareInc2(ShareData share) {
        this.shareData = share;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.inc();
        }
    }
}

class RunnableShareDec2 implements Runnable{
    private ShareData shareData;

    public RunnableShareDec2(ShareData share) {
        this.shareData = share;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.dec();
        }
    }
}

class ShareData2{
    private static int num = 10;

    public synchronized void inc(){
        num++;

        System.out.println(Thread.currentThread().getName() + "_inc:" + num);

        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public synchronized void dec(){
        num--;

        System.out.println(Thread.currentThread().getName() + "_dec:" + num);

        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}