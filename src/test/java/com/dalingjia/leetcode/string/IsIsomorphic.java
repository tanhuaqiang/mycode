package com.dalingjia.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanhq
 * @Description 同构字符串
 * @Date 2019/8/20 下午3:59
 * @Version 1.0
 **/
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //集合中不包含该字符
            if(!map.containsKey(s.charAt(i))){
                //不同的key不能对应相同的value
                if (!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                }else {
                    //不同的key对应相同的value，返回false
                    return false;
                }
            }else {
                if(map.get(s.charAt(i)) == t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }


}

 
    
    
    
    