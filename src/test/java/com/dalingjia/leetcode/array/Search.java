package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  704 二分查找
 * @Date 2019/9/15 下午7:05
 * @Version 1.0
 **/
public class Search {

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int t = (l + r) / 2;
            if (nums[t] == target) {
                return t;
            } else if (nums[t] < target) {
                l = t + 1;
            }else {
                r = t - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(ints, 9));
    }
}

 
    
    
    
    