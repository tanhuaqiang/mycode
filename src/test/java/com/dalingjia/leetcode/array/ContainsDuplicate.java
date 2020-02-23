package com.dalingjia.leetcode.array;


import java.util.*;

/**
 * @author tanhq
 * @Description 存在重复元素
 * @Date 2019/8/20 下午5:16
 * @Version 1.0
 **/
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 先排序，再判断
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}

 
    
    
    
    