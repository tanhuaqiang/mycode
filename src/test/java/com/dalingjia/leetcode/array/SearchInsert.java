package com.dalingjia.leetcode.array;

public class SearchInsert {

    private static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length <=0){
            return 0;
        }
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            if(target <= nums[j] ){
                return j;
            }
            i++;
        }
        return i;
    }
}
