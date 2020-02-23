package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description  747 至少是其他数字两倍的最大数
 * @Date 2019/9/16 下午9:49
 * @Version 1.0
 **/
public class DominantIndex {

    public static int dominantIndex(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int result = nums[0] > nums[1] ? 0 : 1;
        int max = Math.max(nums[0], nums[1]);
        int secondMax = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                result = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (max >= 2 * secondMax) {
            return result;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 0};
        dominantIndex(ints);
    }
}

 
    
    
    
    