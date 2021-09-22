package cn.ainannan.sys.test.duoxiancheng;

public class Multithreading {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 8; i++) {

            if(i % 2 == 0) {
                new Thread(new RunnableShareInc(shareData), "xiancheng_"+i).start();
            } else {
                new Thread(new RunnableShareDec(shareData), "xiancheng_"+i).start();
            }
        }
    }
}

class RunnableShareInc implements Runnable{
    private ShareData shareData;

    public RunnableShareInc(ShareData share) {
        this.shareData = share;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.inc();
        }
    }
}
class RunnableShareDec implements Runnable{
    private ShareData shareData;

    public RunnableShareDec(ShareData share) {
        this.shareData = share;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.dec();
        }
    }
}

class ShareData{
    private static int num = 10;

    public synchronized void inc(){
        num++;

        System.out.println(Thread.currentThread().getName() + "_inc:" + num);
        System.out.println(this.hashCode());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public synchronized void dec(){
        num--;

        System.out.println(Thread.currentThread().getName() + "_dec:" + num);
        System.out.println(this.hashCode());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}