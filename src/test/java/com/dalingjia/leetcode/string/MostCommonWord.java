package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description 819 最常见的单词
 * @Date 2019/9/17 下午5:25
 * @Version 1.0
 **/
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        //替换掉所有非字符串
        String[] strings = paragraph.toLowerCase().replaceAll("[^a-z]", " ").split("\\s+");
        List<String> list = new ArrayList<>();
        for (String s : banned) {
            list.add(s);
        }
        Map<String, Integer> map = new HashMap<>();

        for (String s : strings) {
            if (!list.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int times = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > times) {
                result = entry.getKey();
                times = entry.getValue();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "fa.gd hi, jljh!".replaceAll("[^a-z]", " ");
        String[] s1 = s.split("\\s+");
        System.out.println(s1);
    }
}

 
    
    
    
    