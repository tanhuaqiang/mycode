package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description 908 最小差值I
 * @Date 2019/9/18 下午1:21
 * @Version 1.0
 **/
public class SmallestRangeI {

    /**
     * 其实就是比较A的最大最小值和 2k之间的关系
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        if (A[0] + K >= A[A.length - 1] - K) {
            return 0;
        } else {
            return A[A.length - 1] - K - (A[0] + K);
        }
    }
}

 
    
    
    
    