package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description 628 三个数的最大乘积
 * @Date 2019/9/7 下午9:38
 * @Version 1.0
 **/
public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        Arrays.sort(nums);
        if (nums[0] < 0 && nums[1] < 0) {
            result = Math.max(result, nums[0] * nums[1] * nums[nums.length - 1]);
        }
        result = Math.max(result, nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
        return result;
    }
}

 
    
    
    
    