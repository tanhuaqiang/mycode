package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description 1128 等价多米诺牌对的数量
 * @Date 2019/9/21 下午6:20
 * @Version 1.0
 **/
public class NumEquivDominoPairs {

    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<String, Integer> map = new HashMap();
        for (int[] ints : dominoes) {
            StringBuilder sb = new StringBuilder(Math.min(ints[0], ints[1]) + "" + Math.max(ints[0], ints[1]));
            if (map.containsKey(sb.toString())) {
                map.put(sb.toString(), map.get(sb.toString()) + 1);
            } else {
                map.put(sb.toString(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            count += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
//        numEquivDominoPairs(dominoes);
        Map<String, Integer> map = new HashMap();
        System.out.println(map.get("fsf"));
    }

}

 
    
    
    
    