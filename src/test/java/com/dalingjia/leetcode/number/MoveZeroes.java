package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  移动零
 * @Date 2019/8/21 下午12:27
 * @Version 1.0
 **/
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length ; i++) {
            nums[i] = 0;
        }
    }
}

 
    
    
    
    