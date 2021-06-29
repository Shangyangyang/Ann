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
}
