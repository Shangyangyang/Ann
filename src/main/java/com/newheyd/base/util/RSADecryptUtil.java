package com.newheyd.base.util;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

public class RSADecryptUtil {

    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEQjB5D9-GWsP_NNnDNhEu7Py413J82YemBL5dhPSHith8Xb0FAtJDuMLlLT4_XIAavmwKNn7IJMOeIADB-swOXNVytX8Sv4LKU8NKs5EkMzrkq9vpkF69XaUUx6xhur9al3OK-oBJ_-cGygPZDpZp9moP3q5pZYF_4Xpd63Q-BQIDAQAB";

    public static String decrypt(String input) {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64Util.decodeBase64(PUBLIC_KEY));
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

}
