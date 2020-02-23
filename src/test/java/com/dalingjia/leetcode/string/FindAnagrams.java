package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description  找到字符串中所有字母异位词
 * @Date 2019/8/23 下午3:47
 * @Version 1.0
 **/
public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0){
            return result;
        }

        int[] hash = new int[256];
        char[] pp = p.toCharArray();
        for (char i : pp) {
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- > 0){  //窗口右移；相应的hash值减小；如果这个位置的Hash值是正的，表示p字符串也包含这个，所以count做减法
                count--;
            }
            if (count == 0){
                result.add(left);//count指示器，为0表示和p对应的hash值完全一致
            }
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0){
                //如果当窗口大小一定的时候即窗口大小和需要比较的字符串大小一致的时候，将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个if的地方hash值减小过，所以需要执行对应恢复操作，即：hash值增加，count计数值增加。
                count++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String p = "bdac";

        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}

 
    
    
    
    