package com.dalingjia.leetcode.array;

public class ReversalStringTest {

    public static String revere(String s){
        if(s == null || s.length()<1){
            throw new IllegalArgumentException("字符串不合法");
        }
        StringBuilder sb = new StringBuilder();
        String[] strings = s.split("\\s+");
        int index = strings.length ;
        for (int i = 0; i <= index/2 -1 ; i++) {
            String temp = "";
            temp = strings[i];
            strings[i] = strings[index - 1 - i];
            strings[index -1-i] = temp;
        }
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "student. a    am   I";

        System.out.println(revere(s));
    }
}
