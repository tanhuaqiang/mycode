package com.dalingjia.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tanhq
 * @Description  575 分糖果
 * @Date 2019/9/7 下午3:59
 * @Version 1.0
 **/
public class DistributeCandies {

    /**
     * 返回最大平均种类数
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) {
            set.add(i);
        }
        if (set.size() >= candies.length / 2) {
            return candies.length/2;
        }else {
            return set.size();
        }
     }
}



 
    
    
    
    