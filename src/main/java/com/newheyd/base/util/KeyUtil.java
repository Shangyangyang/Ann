package com.newheyd.base.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class KeyUtil {

    public static void main(String[] args) throws Exception {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = generator.generateKeyPair();

        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        String privateKeyStr = Base64Util.encodeBase64(privateKey.getEncoded());
        String publicKeyStr = Base64Util.encodeBase64(publicKey.getEncoded());

        System.out.println("私钥：" + privateKeyStr);
        System.out.println("公钥：" + publicKeyStr);
    }

}
