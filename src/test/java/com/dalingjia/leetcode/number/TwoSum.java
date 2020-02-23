package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description leetcode 1 两数之和
 * @Date 2019/10/19 下午3:15
 * @Version 1.0
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}

 
    
    
    
    