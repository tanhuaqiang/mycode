package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 重复的子字符串
 * @Date 2019/8/23 下午11:52
 * @Version 1.0
 **/
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            String t = s.substring(0, i);
            StringBuilder sb = new StringBuilder();

        }


        return false;
    }

    public static void main(String[] args) {
        Integer a = 3;
        Integer b = 3;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}

 
    
    
    
    