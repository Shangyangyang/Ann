package cn.ainannan.sys.utils;

import java.util.regex.Pattern;

public class StringUtil {

    /**
     * 判断一个字符串是否是数字。
     *
     * @param str
     * @return
     */
    public static boolean strIsNum(String str) {
        if (str == null)
            return false;
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(str).matches();
    }

    /** 驼峰转下划线(简单写法，效率低于{@link # */
    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }
}
