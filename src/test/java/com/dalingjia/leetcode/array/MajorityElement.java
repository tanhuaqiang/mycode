package com.dalingjia.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanhq
 * @Description 求众数
 * @Date 2019/8/8 下午7:39
 * @Version 1.0
 **/
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            map.put(nums[i], count + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement3(int[] nums) {
        int count = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0 || nums[i] == result) {
                count++;
                result = nums[i];
            } else {
                count--;
            }

        }
        return result;

    }


    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement3(arr));
    }
}

 
    
    
    
    