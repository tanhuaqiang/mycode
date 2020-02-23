package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description 581  最短无序连续子序列
 * @Date 2019/9/7 下午4:14
 * @Version 1.0
 **/
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(nums);
        //找到第一个不同的元素
        int start = 0;
        //找到最后一个不同的元素
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != temp[i]) {
                end = i;
                break;
            }
        }
        return end == start ? 0 : (end - start + 1);
    }
}

 
    
    
    
    