package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description 594 最长和谐子序列
 * @Date 2019/9/7 下午4:41
 * @Version 1.0
 **/
public class FindLHS {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == 0) {
                    continue;
                } else if (nums[j] - nums[i] == 1) {
                    result = Math.max(result, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 找到数字n出现的次数和数字n+1出现的次数，加起来
     * @param nums
     * @return
     */
    public int findLHS2(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (long key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key + 1) + map.get(key));
            }
        }
        return result;


    }

}

 
    
    
    
    