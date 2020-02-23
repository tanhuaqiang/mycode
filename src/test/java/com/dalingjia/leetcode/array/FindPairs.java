package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description 532 数组中的K-diff数对
 * @Date 2019/9/5 下午10:07
 * @Version 1.0
 **/
public class FindPairs {

    public static int findPairs(int[] nums, int k) {
        // k小于0无意义
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        //使用map存放数组元素和元素所对应的下标
        for (int num : nums) {
            map.put(num, i++);
        }
        int result = 0;
        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(nums[j] + k) && map.get(nums[j] + k) != j) {
                map.remove(nums[j] + k);
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {3, 1, 4, 1, 5};
        findPairs(ints, 0);
    }
}



 
    
    
    
    