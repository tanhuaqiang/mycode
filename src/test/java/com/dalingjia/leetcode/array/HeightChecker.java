package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description  1051 高度检查器
 * @Date 2019/9/19 下午11:07
 * @Version 1.0
 **/
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] ints = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            ints[i] = heights[i];
        }
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (ints[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}

 
    
    
    
    