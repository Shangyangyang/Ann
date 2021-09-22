package cn.ainannan.sys.test.duoxiancheng;

public class VolatileTest {
    public volatile int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        System.out.println("Thread.activeCount() = " + Thread.activeCount());
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
//                        System.out.println(Thread.currentThread().getName() + ":" + j);
                        test.increase();
                }

                ;
            }.start();
        }

        while (Thread.activeCount() > 2)  //保证前面的线程都执行完
//            System.out.println("Thread.activeCount() = " + Thread.activeCount());
            Thread.yield();
        System.out.println(test.inc);
    }
}
