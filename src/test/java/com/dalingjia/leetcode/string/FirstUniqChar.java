package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description 字符串中的第一个唯一字符
 * @Date 2019/8/22 上午10:50
 * @Version 1.0
 **/
public class FirstUniqChar {

    public static int firstUniqChar(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (list.contains(key)) {
                continue;
            }
            boolean flag = true;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == key) {
                    flag = false;
                    list.add(key);
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }


    public int firstUniqChar2(String s) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}

 
    
    
    
    