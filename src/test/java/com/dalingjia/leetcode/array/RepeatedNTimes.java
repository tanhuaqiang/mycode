package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description  961 重复N次的元素
 * @Date 2019/9/18 下午10:44
 * @Version 1.0
 **/
public class RepeatedNTimes {

    public int repeatedNTimes(int[] A) {

        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (!set.add(i)) {
                return i;
            }
        }
        return -1;
    }
}

 
    
    
    
    