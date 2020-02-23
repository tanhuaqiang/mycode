package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  找不同
 * @Date 2019/8/22 上午11:53
 * @Version 1.0
 **/
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (arr[t.charAt(i) - 'a'] != 0) {
                arr[t.charAt(i) - 'a']--;
            } else {
                return t.charAt(i);
            }
        }
        return 0;
    }


    public char findTheDifference2(String s, String t) {
        char diff = 0;
        for (int i = 0; i < s.length(); i++) {
            diff ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            diff ^= t.charAt(i);
        }
        return diff;
    }

}

 
    
    
    
    