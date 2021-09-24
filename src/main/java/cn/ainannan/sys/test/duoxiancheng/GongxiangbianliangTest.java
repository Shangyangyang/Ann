package cn.ainannan.sys.test.duoxiancheng;

public class GongxiangbianliangTest {
    public static void main(String[] args) {
        Sp sp = new Sp();

        ShengchanI sc = new ShengchanI(sp);
        XiaofeiI xf = new XiaofeiI(sp);

        Thread t1 = new Thread(sc);
        Thread t2 = new Thread(xf);

        t1.start();
        t2.start();
    }
}

class Sp {
    private String name;
    private int count = 1;
    private boolean flag = false; // false 生产 true 消费

    public synchronized void set(String name){

        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.name = name + "---" + count++;

        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        this.notifyAll();
    }

    public synchronized void out(){

        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        this.notifyAll();
    }
}

class ShengchanI implements Runnable{

    private Sp sp;

    public ShengchanI(Sp sp){
        this.sp = sp;
    }

    @Override
    public void run() {
        while (true){
            sp.set("商品");
        }
    }
}

class XiaofeiI implements Runnable{

    private Sp sp;

    public XiaofeiI(Sp sp){
        this.sp = sp;
    }

    @Override
    public void run() {
        while (true){
            sp.out();
        }
    }
}
