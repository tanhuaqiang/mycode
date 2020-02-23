package com.dalingjia.leetcode.number;

import java.util.*;

/**
 * @author tanhq
 * @Description  二进制手表
 * @Date 2019/8/22 下午2:37
 * @Version 1.0
 **/
public class ReadBinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                // 64：1000000 ，64用于将小时和分钟隔开
                // bitCount(int i) :返回指定 int 值的二进制补码表示形式的 1 位的数量
                if (Integer.bitCount(h * 64 + m) == num){
                    //%02d : 至少2位十进制数
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(String.format("%02d", 2));
        System.out.println(String.format("%02d", 10));
        System.out.println(String.format("%02d", 102));
        System.out.println(String.format("%02d", 1092));
        System.out.println(Integer.bitCount(5));
        System.out.println(Integer.bitCount(8));
        System.out.println(Integer.bitCount(14));
    }
}

 
    
    
    
    