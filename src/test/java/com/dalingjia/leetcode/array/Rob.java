package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 打家劫舍     很明显的是动态规划题。对于动态规划题就是找他的动态规划方程，也就是找规律。
 * @Date 2019/8/19 下午8:36
 * @Version 1.0
 **/
public class Rob {

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //定义个数组，存储打劫到第n个房间能获得最大金额数总和
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        //当数组大于2个数时，当前的房子可选择打劫或者不打劫。
        //1 打劫的话就是当前房子的金额加上i-2时能打劫到的最大金额（已经存放list中）
        //2 不打劫的话，就是打劫上一个房间的最大金额，
        //然后比较这俩哪个最大，最大的就是当前最大的打劫金额
        for (int i = 2; i < nums.length; i++) {
            int a = nums[i] + result[i - 2];    //打劫当前房间
            int b = result[i - 1];              //不打劫当前房间

            result[i] = Math.max(a, b);         //取二者的最大值
        }
        return result[result.length - 1];
    }


    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2};
        System.out.println(rob(arr));
    }
}

 
    
    
    
    