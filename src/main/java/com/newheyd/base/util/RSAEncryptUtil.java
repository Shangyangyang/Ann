package com.newheyd.base.util;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;

public class RSAEncryptUtil {

    private static final String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMRCMHkP34Zaw_802cM2ES7s_LjXcnzZh6YEvl2E9IeK2HxdvQUC0kO4wuUtPj9cgBq-bAo2fsgkw54gAMH6zA5c1XK1fxK_gspTw0qzkSQzOuSr2-mQXr1dpRTHrGG6v1qXc4r6gEn_5wbKA9kOlmn2ag_ermllgX_hel3rdD4FAgMBAAECgYBcXPYpE3JT7cWOBtZxS7G8juXFLAgCf_GaDWN16cuXOp31sbvybsh7_KkkaC2CbksPywxXphv2n268rT0ODbUYPe3xMJn-M2gFhI2P5WiuxZFuM7VMKaSV17lD3NVCBceS91q2ni0TrhSarZW_otGPO0m-R2FUE-pgLULvaSdExQJBAO6cnUIkD95_DpW3EIx42i6qDLmMD04CwuN0FgxuYIa5IpVBQg_pPthXTzanLKXLPH8Yh54Xo60Eku0IhO4EWLsCQQDSj3YA1EcAvFhHCk5dG2zRbVzOGk0ocs7XU2-DKm0LziuZu-i1-EwLHVXdgvXCzF9VmGsvL9jokRPV5kA-FLg_AkBMbO9VovVOP4XtYCA1zfOcJK1EtN6mDu5bKfBx9NyH6j5wbeF59SxC4NwnVi5PwCPVVYcClPHA1gk1UJg7IDtHAkBHUMnB7CQETsaDgS0bge9wW18ke2oIuiHuclcBkPwQFItV7XwbLfbriMsNVI7SpI_hmNcsy0LnOkQCnZLCtBfXAkBdzchpKRAb5KxGZpqBEtxNK5eECslkX9rnISkrPeZ7P9fwiuDBgFf874Toak5mB8TiiTwRkWhwrmxdKkXAupCo";

    /*
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
    */

    public static String encrypt(String input) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64Util.decodeBase64(PRIVATE_KEY));
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

    public static void main(String[] args) {

        String test = "admin1234567";

        System.out.println(test);

        String test1 = encrypt(test);

        System.out.println(test1);

        //String test2 = decrypt(test1);

        //System.out.println(test2);

    }

}
