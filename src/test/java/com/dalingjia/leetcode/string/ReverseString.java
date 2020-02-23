package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 反转字符串
 * @Date 2019/8/21 下午4:35
 * @Version 1.0
 **/
public class ReverseString {

    public void reverseString(char[] s) {
        if(s == null || s.length == 0){
            return;
        }
        int mid = (s.length - 1) / 2;
        for (int i = 0; i <= mid; i++) {
            char t = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length -1-i] = t;
        }
    }
}

 
    
    
    
    