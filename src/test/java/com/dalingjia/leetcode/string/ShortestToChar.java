package com.dalingjia.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanhq
 * @Description 821 字符的最短距离
 * @Date 2019/9/17 下午5:50
 * @Version 1.0
 **/
public class ShortestToChar {

    public int[] shortestToChar(String S, char C) {
        int[] ints = new int[S.length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (C == S.charAt(i)) {
                list.add(i);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            ints[i] = 10000;
            if (S.charAt(i) == C) {
                ints[i] = 0;
            }else {
                for (Integer integer : list) {
                    ints[i] = Math.min(ints[i], Math.abs(i - integer));
                }
            }
        }
        return ints;
    }
}

 
    
    
    
    