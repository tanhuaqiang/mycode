package com.dalingjia.leetcode.array;

public class NumberOfOne {

    public static int findNumberOfOne(int start, int end){
        int count = 0;
        for (int i = start; i <=end ; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int t = Character.digit(chars[j], 10);
                if(t == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfOne(1, 13));
    }
}
