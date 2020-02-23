package com.dalingjia.leetcode.string;


import java.util.HashMap;
import java.util.Map;

/**
 * @author tanhq
 * @Description  单词规律
 * @Date 2019/8/21 下午3:32
 * @Version 1.0
 **/
public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strings = str.split("\\s+");
        Map<Character, String> map = new HashMap();
        if(chars.length != strings.length ){
            return false;
        }
        for (int i = 0; i < chars.length; i++) {

            if(!map.containsKey(chars[i])){
                //排除key不同，value相同的情况
                if (map.containsValue(strings[i])) {
                    return false;
                } else {
                    map.put(chars[i], strings[i]);
                }
            }else {
                if(!strings[i].equals(map.get(chars[i]))){
                    return false;
                }

            }
        }
        return true;
    }


    public static void main(String[] args) {
        String pattern = "abba";
        String strings = "dog dog cat fish";
        System.out.println(wordPattern(pattern, strings));
    }
}

 
    
    
    
    