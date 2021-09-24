package cn.ainannan.sys.test;

public class ShejiMoshiTest {

    public static void main(String[] args) {
        method2();
    }


    /**
     * 单例模式 - 饿汉模式
     */
    public static void method1() {
        ShejiMoshiTestObj shejiMoshiTestObj = ShejiMoshiTestObj.getInstance();
    }
    /**
     * 普通工厂模式
     */
    public static void method2() {
        GongchangTest.getSender("sms").send();
    }

}

interface GongchangInterface{
    void send();
}

class GongchangTest{
    public static GongchangInterface getSender(String type){
        switch (type){
            case "mail":
                return new MailSend();
            case "sms":
                return new SmsSend();
            default:
                System.out.println("错误的类型");
                return null;
        }
    }
}

class MailSend implements GongchangInterface{
    @Override
    public void send() {
        System.out.println("mail send!");
    }
}

class SmsSend implements GongchangInterface{
    @Override
    public void send() {
        System.out.println("sms send!");
    }
}

















class ShejiMoshiTestObj {
    private static ShejiMoshiTestObj smto = null;

    private ShejiMoshiTestObj(){

    }

    /**
     * 懒汉模式
     * @return
     */
    public static ShejiMoshiTestObj getInstance(){
        if(smto == null){
            synchronized (smto.getClass()){
                if(smto == null){
                     smto = new ShejiMoshiTestObj();
                }
            }
        }
        return smto;
    }
}
