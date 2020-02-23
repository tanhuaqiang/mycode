package com.dalingjia.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tanhq
 * @Description  645 错误的集合
 * @Date 2019/9/8 下午6:23
 * @Version 1.0
 **/
public class FindErrorNums {

    public int[] findErrorNums(int[] nums) {
        int sum1 = 0;
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            sum1 += i;
            if (!set.add(i)) {
                result[0] = i;
            }
        }
        int sum2 = (1+nums.length)*nums.length/2;
        result[1] = result[0] + (sum2 - sum1);
        return result;
    }
}

 
    
    
    
    