package com.dalingjia.leetcode.array;

public class PalindromeNumber {

    private static boolean palindrome(int x){
        boolean flag = true;
        char[] chars = Integer.valueOf(x).toString().toCharArray();
        int length = chars.length;
        for (int i = 0; i < length/2; i++) {
            if(chars[i] != chars[length-i-1]){
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(palindrome(121));
        System.out.println(palindrome(-121));
        System.out.println(palindrome(10));
    }
}
