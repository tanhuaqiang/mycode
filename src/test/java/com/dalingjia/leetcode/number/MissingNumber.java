package com.dalingjia.leetcode.number;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description  缺失数字
 * @Date 2019/8/21 上午11:43
 * @Version 1.0
 **/
public class MissingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        int sum = (1+nums.length)*nums.length/2;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        return sum - sum2;
    }
}

 
    
    
    
    