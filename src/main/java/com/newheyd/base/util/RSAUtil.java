package com.newheyd.base.util;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    public static String decrypt(String input, String pubKey) {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64Util.decodeBase64(pubKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key key = keyFactory.generatePublic(keySpec);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] data = cipher.doFinal(Base64Util.decodeBase64(input));

            return new String(data, "UTF-8");
        } catch (Exception ex) {
            return "";
        }
    }

    public static String encrypt(String input, String priKey) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64Util.decodeBase64(priKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key key = keyFactory.generatePrivate(keySpec);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] data = cipher.doFinal(input.getBytes("UTF-8"));

            return Base64Util.encodeBase64(data);
        } catch (Exception ex) {
            return "";
        }
    }

}
