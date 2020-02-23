package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description leetcode 482 密钥格式化
 * @Date 2019/9/5 下午4:24
 * @Version 1.0
 **/
public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase().replace("-", "");
        StringBuilder sb = new StringBuilder(S);
        for (int i = sb.length(); i > K; i -= K) {
            sb.insert(i - K, "-");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println("2g".toUpperCase());
        System.out.println("2g-r9".toUpperCase());
        StringBuilder s2 = new StringBuilder("abcdefgh");
        System.out.println(licenseKeyFormatting(s2.toString(), 3));
    }
}

 
    
    
    
    