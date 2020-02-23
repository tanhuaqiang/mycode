package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  字符串中的单词数
 * @Date 2019/8/23 上午9:32
 * @Version 1.0
 **/
public class CountSegments {
    public int countSegments(String s) {
        if(s == null){
            return 0;
        }
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        return s.split("\\s+").length;
    }


    public static void main(String[] args) {
        String[] strings = "fa cd    df".split("\\s+");
        System.out.println(strings.length);
        String s = "fa cd    df";
        System.out.println(s.trim().split("\\s+").length);
    }
}

 
    
    
    
    