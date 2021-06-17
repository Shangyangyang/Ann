package com.newheyd.base.util;

public class RSALiXiaDecUtil {

    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKlKHXEeiIpz6mwGzOlhLgFtigvzRE1WRJl6LxBVfbXmmvl77ajF69KutjMpi5fzG0Anjnvo1xNoJvSm4OaWDvMZ8VQTsncxNGabzXvWkU7rfno4rUQsvF4O_R9i8ADVU_MBo3UVI3ljAVsBiExFfCjAr2mKZQ5KTZqD7f8Lg5CwIDAQAB";

    public static String decrypt(String input) {
        return com.newheyd.base.util.RSAUtil.decrypt(input, PUBLIC_KEY);
    }

    public static void main(String[] args) {

        String test = "admin1234567";

        System.out.println(test);

        String test1 = com.newheyd.base.util.RSALiXiaEncUtil.encrypt(test);

        System.out.println(test1);

        String test2 = RSALiXiaDecUtil.decrypt(test1);

        System.out.println(test2);
    }

}
