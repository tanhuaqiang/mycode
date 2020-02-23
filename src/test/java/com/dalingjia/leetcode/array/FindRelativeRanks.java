package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description 506  相对名次
 * @Date 2019/9/5 下午8:37
 * @Version 1.0
 **/
public class FindRelativeRanks {

    public static String[] findRelativeRanks(int[] nums) {
        String[] s = new String[nums.length];
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (temp[i] == nums[j]) {
                    if (j == nums.length - 1) {
                        s[i] = "Gold Medal";
                    } else if (j == nums.length - 2) {
                        s[i] = "Silver Medal";
                    } else if (j == nums.length - 3) {
                        s[i] = "Bronze Medal";
                    } else {
                        s[i] = String.valueOf(nums.length - j);
                    }
                    break;
                }
            }
        }

        return s;
    }


    public static void main(String[] args) {
        int[] nums = {4, 5};
        findRelativeRanks(nums);
    }
}

 
    
    
    
    