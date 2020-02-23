package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description  第三大的数
 * @Date 2019/8/22 下午7:56
 * @Version 1.0
 **/
public class ThirdMax {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) {
            return nums[nums.length - 1];
        }
        int index = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (index == 3) {
                return nums[i];
            }
            while ((i - 1) >= 0 && nums[i] == nums[i - 1]) {
                i--;
            }
            index++;
        }
        return nums[nums.length - 1];
    }

    public int thirdtwo(int[] nums) {
        Integer one = null;
        Integer two = null;
        Integer three = null;
        for (Integer n : nums) {
            if (n.equals(one) || n.equals(two) || n.equals(three)) {
                continue;
            }
            if (one == null || n > one) {
                three = two;
                two = one;
                one = n;
            } else if (two == null || n > two) {
                three = two;
                two = n;
            } else if (three == null || n > three) {
                three = n;
            }
        }
        return three == null ? one : three;
    }
    
    
}

 
    
    
    
    