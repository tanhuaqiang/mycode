package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description  1046 最后一块石头的重量
 * @Date 2019/9/19 下午10:19
 * @Version 1.0
 **/
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        int t = 0;
        int len = stones.length;
        for (int i = 0; i < stones.length-1; i++) {
            Arrays.sort(stones);
            t = stones[len - 1] - stones[len - 2];
            stones[len-2] = 0;//粉碎x
            stones[len - 1] = t;//y

        }
        return stones[len - 1];
    }
}

 
    
    
    
    