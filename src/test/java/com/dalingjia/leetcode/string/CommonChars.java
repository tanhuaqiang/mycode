package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description  1002 查找常用字符
 * @Date 2019/9/19 下午4:05
 * @Version 1.0
 **/
public class CommonChars {

    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();

        if(A==null || A.length<=0){
            return list;
        }

        int[] chars = new int[26];
        for(int i = 0;i < 26;i++){
            chars[i] = Integer.MAX_VALUE;
        }

        //取字符串中字符出现次数最少的情况
        for(String str : A){
            char[] content = str.toCharArray();
            int[] charsTemp = new int[26];
            for(char c : content){
                charsTemp[c-97]++;
            }
            for(int i = 0;i < 26;i++){
                if(charsTemp[i] < chars[i]){
                    chars[i] = charsTemp[i];
                }
            }
        }

        for(int i = 0;i < chars.length;i++){
            for(int k = 0; k < chars[i];k++){
                list.add((char) (i+'a')+"");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdgfd");
        sb.deleteCharAt(3);
        System.out.println(sb);
    }
}

 
    
    
    
    