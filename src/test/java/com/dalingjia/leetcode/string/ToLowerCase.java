package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  709 转换成小写字母
 * @Date 2019/9/15 下午7:17
 * @Version 1.0
 **/
public class ToLowerCase {

    public String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                chars[i] += 32;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        char c = 'A';//65
        System.out.println(c += 32);
        System.out.println(c);
        char[] chars = {'e', 'G', 'S'};
        System.out.println(String.valueOf(chars));
    }
}

 
    
    
    
    