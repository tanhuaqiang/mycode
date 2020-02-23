package com.dalingjia.leetcode.string;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author tanhq
 * @Description 1189 气球的最大数量
 * @Date 2019/9/22 下午11:29
 * @Version 1.0
 **/
public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        int[] ints = new int[26];
        char[] chars = text.toCharArray();
        for (char c : chars) {
            ints[c - 'a']++;
        }
        int count = 0;
        while (true) {
            if (ints['a' - 'a'] < 1) {
                break;
            } else {
                ints['a' - 'a']--;
            }
            if (ints['b' - 'a'] < 1) {
                break;
            } else {
                ints['b' - 'a']--;
            }
            if (ints['l' - 'a'] < 2) {
                break;
            } else {
                ints['l' - 'a'] -= 2;
            }
            if (ints['n' - 'a'] < 1) {
                break;
            } else {
                ints['n' - 'a']--;
            }
            if (ints['o' - 'a'] < 2) {
                break;
            } else {
                ints['o' - 'a'] -= 2;
            }
            count++;
        }
        return count;
    }



}

 
    
    
    
    