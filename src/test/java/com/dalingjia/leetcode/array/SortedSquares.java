package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description  977 有序数组的平方
 * @Date 2019/9/19 上午11:50
 * @Version 1.0
 **/
public class SortedSquares {

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);

        return A;
    }

}

 
    
    
    
    