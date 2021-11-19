package cn.ainannan.sys.test.image;

public class BusinessException extends Throwable {
    public BusinessException(String s) {
        System.out.println("s = " + s);
    }
}
