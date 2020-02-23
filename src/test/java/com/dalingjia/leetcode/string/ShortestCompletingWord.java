package com.dalingjia.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tanhq
 * @Description 748 最短完整词
 * @Date 2019/9/16 下午10:15
 * @Version 1.0
 **/
public class ShortestCompletingWord {

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        //长的，大于0，排在后面
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        //将牌照字符存到数组中
        char[] chars = licensePlate.toLowerCase().toCharArray();
        int[] ints = new int[26];
        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                ints[c-'a']++;
            }
        }
        for (int i = 0; i < words.length; i++) {
            int[] ints1 = new int[26];
            boolean flag = true;
            //将字符串字符存到数组中
            char[] chars1 = words[i].toCharArray();
            for (char c : chars1) {
                if (c >= 'a' && c <= 'z') {
                    ints1[c-'a']++;
                }
            }
            for (int j = 0; j < 26; j++) {
                if (ints[j] > ints1[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return words[i];
            }
        }
        return "";
    }


    public static void main(String[] args) {
        String[] s = {"step","steps","stripe","stepple"};
        String l = "1s3 PSt";

        System.out.println(shortestCompletingWord(l, s));
    }


}

 
    
    
    
    