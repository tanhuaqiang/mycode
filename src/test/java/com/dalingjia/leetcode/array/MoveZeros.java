package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 283  移动零
 * @Date 2022/5/10 下午1:38
 * @Version 1.0
 **/
public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //记录不为0的元素个数
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}

 
    
    
    
    