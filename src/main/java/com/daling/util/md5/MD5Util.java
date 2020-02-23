package com.daling.util.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class MD5Util {

    public static String messageDigestMD5(Object[] objects){
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for(Object object : objects){
                stringBuffer.append(object);
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(stringBuffer.toString().getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            try {
                throw new SQLException("生成 code 失败");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Long couponId = System.currentTimeMillis();
        Object[] objects = {1194, couponId, 5, 0};
        String string = messageDigestMD5(objects);
        System.out.println(string);
        System.out.println(string.length());
    }
}
