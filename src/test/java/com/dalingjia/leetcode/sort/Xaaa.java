package com.dalingjia.leetcode.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2022/6/1 下午3:33
 * @Version 1.0
 **/
public class Xaaa {


    public static void main(String[] args) {
        String s = "1";
        String t = "99";
        System.out.println(solve(s, t));
    }


    public static String solve(String s, String t) {
        int maxLength = Math.max(s.length(), t.length());
        int[] arr1 = new int[maxLength];
        int[] arr2 = new int[maxLength];
        int[] result = new int[maxLength + 1];
        int i1 = 0;
        int i2 = 0;
        if ("".equals(s)) {
            s = "0";
        }
        if ("".equals(t)) {
            t = "0";
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            arr1[i1++] = s.charAt(i) - '0';
        }
        for (int i = t.length() - 1; i >= 0; i--) {
            arr2[i2++] = t.charAt(i) - 48;
        }
        for (int i = 0; i < maxLength; i++) {
            int sum = arr1[i] + arr2[i] + result[i];
            if (sum >= 10) {
                result[i] = sum - 10;
                result[i + 1] = 1;
            } else {
                result[i] = sum;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[result.length - 1] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

}

 
    
    
    
    