package com.dalingjia.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanhq
 * @Description 存在重复元素
 * @Date 2019/8/20 下午5:28
 * @Version 1.0
 **/
public class ContainsNearbyDuplicate {

    /**
     * 思路：将数组元素与元素索引存入map中，如果元素相同，则比较索引差的绝对值；若 <=k ,返回true；否则存入新的索引
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else {
                if(i - map.get(nums[i]) <= k ){
                    return true;
                }else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;

    }


}

 
    
    
    
    