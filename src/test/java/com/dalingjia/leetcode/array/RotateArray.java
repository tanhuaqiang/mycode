package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/8/9 上午10:44
 * @Version 1.0
 **/
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        //求余数
        int turns = k % nums.length;
        reverse(nums, 0, nums.length - 1 - turns);
        reverse(nums, nums.length - turns, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    /**
     * 反转数组
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(arr, 3);
        System.out.println(arr);


        System.out.println(2 & 1);
    }


}


 
    
    
    
    