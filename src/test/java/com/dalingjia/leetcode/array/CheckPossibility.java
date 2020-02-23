package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 665 非递减数列
 * @Date 2019/9/8 下午7:00
 * @Version 1.0
 **/
public class CheckPossibility {

    public boolean CheckPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        //用来记录修改数组次数
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            //如果索引i的值比i-1的值大，进行下一次循环
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            count++;
            //如果nums[i]的值比nums[i-2]的值小，将nums[i-1]的值赋给nums[i]
            if (i >= 2 && nums[i] < nums[i - 2]) {
                nums[i] = nums[i - 1];
            } else
                //如果只是nums[i]的值小于nums[i-1],将nums[i]的值赋给nums[i-1]
                nums[i - 1] = nums[i];
        }
        //如果数组修改次数为0或者1，返回true
        return count <= 1;
    }
}

 
    
    
    
    