package com.newheyd.base.util;

import java.util.Random;

public class RandomUtil {

    public static String random(int length) {

        StringBuilder str = new StringBuilder();

        Random random = new Random();

        //随机生成数字，并添加到字符串
        for (int i = 0; i < length; i++) {
            str.append(random.nextInt(10));
        }

        //将字符串转换为数字并输出
        return str.toString();
    }

}
