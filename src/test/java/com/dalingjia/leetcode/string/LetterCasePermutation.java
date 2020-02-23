package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description 784 字母大小写全排列
 * @Date 2019/9/17 下午2:55
 * @Version 1.0
 **/
public class LetterCasePermutation {

    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        dfs(0, new StringBuilder(S));
        return res;
    }

    private void dfs(int x, StringBuilder s) {
        if (x == s.length()) {
            res.add(s.toString());
            return;
        }
        char c = s.charAt(x);
        if (Character.isLetter(c)) {
            s.setCharAt(x, Character.toLowerCase(c));
            dfs(x +1, s);
            s.setCharAt(x, Character.toUpperCase(c));
            dfs(x +1, s);
        }else {
            dfs(x + 1, s);
        }
    }


    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("a1b2");
        System.out.println(String.valueOf(s.charAt(0)).toUpperCase());
        System.out.println(s.substring(0, 0));
        System.out.println(s.substring(4));
        s.setCharAt(0, Character.toUpperCase(s.charAt(0)));
        System.out.println(s);
//        letterCasePermutation(s);
    }
}

 
    
    
    
    