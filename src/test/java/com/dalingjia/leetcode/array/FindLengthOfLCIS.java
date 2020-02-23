package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  674 最长连续递增序列
 * @Date 2019/9/8 下午9:55
 * @Version 1.0
 **/
public class FindLengthOfLCIS {

    //1,3,5,4,7
    public int findLengthOfLCIS(int[] nums) {
        //special case
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        //general case
        int max = 1, count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}

 
    
    
    
    