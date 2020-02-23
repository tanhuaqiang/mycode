package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 697 数组的度
 * @Date 2019/9/15 下午6:24
 * @Version 1.0
 **/
public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        int minLength = 50000;
        int currLength;
        int maxFrequency = 0;
        int[] frequency = new int[50001];
        int[] pos = new int[50001];

        if (nums.length == 1) {
            return 1;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (pos[nums[i - 1]] != 0) {
                frequency[nums[i - 1]]++;
                currLength = i - pos[nums[i - 1]] + 1;
                if (frequency[nums[i - 1]] > maxFrequency) {
                    maxFrequency = frequency[nums[i - 1]];
                    minLength = currLength;
                } else if (frequency[nums[i - 1]] == maxFrequency) {
                    minLength = currLength < minLength ? currLength : minLength;
                }
            } else {
                pos[nums[i - 1]] = i;
            }
        }
        if (maxFrequency == 0) {
            return 1;
        }
        return minLength;

    }
}

 
    
    
    
    