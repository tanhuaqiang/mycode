package com.dalingjia.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanhq
 * @Description 有效的字母异位词
 * @Date 2019/8/21 上午9:29
 * @Version 1.0
 **/
public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null){
            return true;
        }
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }
        if(s!= null && t!= null && s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if(!map.containsKey(t.charAt(i))){
                return false;
            }else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if(map.get(t.charAt(i)) == 0){
                    map.remove(t.charAt(i));
                }
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return String.valueOf(s1).equals(String.valueOf(t1));
    }
}

 
    
    
    
    