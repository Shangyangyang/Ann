package com.newheyd.base.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    private static final String IV_KEY = "newheydzhongtian";

    private static final String PASS_KEY = "xinzhongtianheyd";


    public static String encrypt(String content) {
        try {
            SecretKeySpec aesKey = new SecretKeySpec(PASS_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(IV_KEY.getBytes()));
            byte[] data = cipher.doFinal(content.getBytes("UTF-8"));
            return com.newheyd.base.util.Base64Util.encodeBase64(data);
        } catch (Exception e) {
            return "";
        }
    }

    public static String decrypt(String content) {
        byte[] contentBytes = com.newheyd.base.util.Base64Util.decodeBase64(content);
        try {
            SecretKeySpec aesKey = new SecretKeySpec(PASS_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(IV_KEY.getBytes()));
            byte[] result = cipher.doFinal(contentBytes);
            return new String(result, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args) {

        //String content = "梅须逊雪三分白，雪却输梅一段香。";

        String content = null;

        System.out.println("加密前：" + content);
        String encryptResult = encrypt(content);
        System.out.println("加密后：" + encryptResult);
        String decryptResult = decrypt(encryptResult);
        System.out.println("解密后：" + decryptResult);
    }

}
