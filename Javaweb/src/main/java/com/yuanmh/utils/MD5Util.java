package com.yuanmh.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {
    //盐值
    public static final String SALT = "yuanmh";

    public static String getMD5String(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return new BigInteger(1, digest).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}