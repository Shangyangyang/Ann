package com.newheyd.base.util;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class Base64Util {

    public static String encodeBase64(byte[] input) {
        try {
            return new String(Base64.encodeBase64URLSafe(input), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static byte[] decodeBase64(String input) {
        try {
            return Base64.decodeBase64(input.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
