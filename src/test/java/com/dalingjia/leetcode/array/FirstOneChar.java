package com.dalingjia.leetcode.array;

import com.google.common.collect.Maps;

import java.util.Map;

public class FirstOneChar {


    private static int[] arr = new int[256];

    private static Map<Character, Integer> findFirstOneChar(String str){
        Map<Character, Integer> map = Maps.newHashMap();
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            arr[chars[i]]++;
        }

        for (int i = 0; i < length; i++) {
            if(arr[chars[i]] == 1){
                map.put(chars[i], i);
                return map;
            }
        }
        return map;
    }


    public static void main(String[] args) {
        String s = "abcdbacgighe";
        System.out.println(findFirstOneChar(s));
    }
}
