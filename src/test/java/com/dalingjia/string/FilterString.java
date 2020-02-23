package com.dalingjia.string;

import java.util.HashSet;
import java.util.Set;

public class FilterString {

    private static String filterString(String s) {
        Set<Character> set = new HashSet<Character>();
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(!set.contains(s.charAt(i))){
                sb.append(s.charAt(i));
                set.add(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(filterString(""));
        System.out.println(filterString("abcadjl"));
        System.out.println(filterString("29eabde2"));
    }
}
