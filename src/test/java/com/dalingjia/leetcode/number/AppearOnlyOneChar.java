package com.dalingjia.leetcode.number;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class AppearOnlyOneChar {

    public static Map firstNotRepeatingChar(String str) {
        Map<Character, Integer> map = Maps.newHashMap();
        //哈希表的使用
        int mapArr[]=new int[256];
        char chs[]=str.toCharArray();
        int lens=chs.length;

        for(int i=0;i<lens;i++){
            mapArr[chs[i]]++;
        }

        for(int i=0;i<lens;i++){
            if(mapArr[chs[i]]==1){
                map.put(chs[i], i);
                return map;
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String string = "abcegbsacd";
        System.out.println(firstNotRepeatingChar(string));

        System.out.println(7%1000000007);
    }
}
