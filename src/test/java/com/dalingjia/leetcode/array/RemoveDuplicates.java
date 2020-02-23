package com.dalingjia.leetcode.array;

/**
 * leetcode 26 删除排序数组中的重复项
 */
public class RemoveDuplicates {

    private static int removeDuplicates(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int t = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[t]) {
                t++;
                nums[t] = nums[i];
            }
        }
        return t + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
    }
}
