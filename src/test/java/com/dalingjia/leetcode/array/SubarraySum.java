package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description 560 和为K的子数组
 * @Date 2019/10/1 下午10:12
 * @Version 1.0
 **/
public class SubarraySum {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, -1, -1, 1, 5};
        System.out.println(subarraySum(ints, 1));
    }

}

 
    
    
    
    