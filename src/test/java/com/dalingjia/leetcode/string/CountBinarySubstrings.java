package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 696 计算二进制子串
 * @Date 2019/9/15 上午10:43
 * @Version 1.0
 **/
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int[] arr = new int[s.length()];
        int t = 0; //数组下标
        arr[0] = 1;//形同元素的个数
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                arr[++t] = 1;
            } else {
                arr[t]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= t; i++) {
            //取最小值作为满足条件的最小子串
            ans += Math.min(arr[i - 1], arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountBinarySubstrings c = new CountBinarySubstrings();
        String s = "00110";
        c.countBinarySubstrings(s);
    }
}

 
    
    
    
    