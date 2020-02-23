package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description  976 三角形的最大周长
 * @Date 2019/9/18 下午11:20
 * @Version 1.0
 **/
public class LargestPerimeter {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            //2边这和大于第三边
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}

 
    
    
    
    