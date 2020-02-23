package com.dalingjia.algorithm.AHaAlgorithm;

import java.util.ArrayDeque;

public class PalindromeString {

    public static boolean palindrome(String s){
        boolean flag = false;
        int mid = s.length()/2-1;
        ArrayDeque stack = new ArrayDeque();
        //入栈
        for (int i = 0; i <= mid ; i++) {
            stack.push(s.charAt(i));
        }
        //出栈进行比较
        for (int i = s.length()-mid-1; i <s.length() ; i++) {
            //不拿走
            if((char)stack.peek() != s.charAt(i)){
                break;
            }
            stack.pop();//拿走元素
        }
        //全部相等，栈才会被取空
        if(stack.isEmpty()){
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "abcdefedcba";
        String s1 = "abcdeffedcba";
        String s2 = "abcdefeedcba";
        System.out.println(palindrome(s));
        System.out.println(palindrome(s1));
        System.out.println(palindrome(s2));
    }
}
