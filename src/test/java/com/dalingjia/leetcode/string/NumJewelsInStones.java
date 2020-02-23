package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  771 宝石和石头
 * @Date 2019/9/17 下午2:27
 * @Version 1.0
 **/
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        int[] ints = new int[128];
        for (int i = 0; i < J.length(); i++) {
            ints[J.charAt(i)-'A']++;
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (ints[S.charAt(i) - 'A'] > 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println('a'-0);
        System.out.println('A');
    }
}

 
    
    
    
    