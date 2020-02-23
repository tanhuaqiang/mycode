package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description  500 键盘行
 * @Date 2019/9/5 下午6:33
 * @Version 1.0
 **/
public class FindWords {

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if(judge(words[i])){
                list.add(words[i]);
            }
        }
        return list.toArray(new String[list.size()]);

    }

    private boolean judge(String word) {
        String[] strings = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        word = word.toLowerCase();
        String s = strings[0];
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].contains(word.substring(0,1))){
                s = strings[i];
            }
        }
        for (int i = 1; i < word.length(); i++) {
            if(!s.contains(word.substring(i,i+1))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String[] s = list.toArray(new String[list.size()]);
        System.out.println(s);
    }
}

 
    
    
    
    