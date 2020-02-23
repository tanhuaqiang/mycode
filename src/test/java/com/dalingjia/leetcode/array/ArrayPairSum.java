package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description  561 数组拆分I
 * @Date 2019/9/7 下午3:04
 * @Version 1.0
 **/
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}

 
    
    
    
    