package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description  884 两句话中的不常见单词
 * @Date 2019/9/18 上午9:57
 * @Version 1.0
 **/
public class UncommonFromSentences {

    public String[] uncommonFromSentences(String A, String B) {
        String[] sa = A.split("\\s+");
        String[] sb = B.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String s : sa) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : sb) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                set.add(entry.getKey());
            }
        }
        String[] res = new String[set.size()];
        int i = 0;
        for (String s : set) {
            res[i++] = s;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println("".length());
        String[] s = "".split("\\s+");
        System.out.println(s);
    }
}

 
    
    
    
    