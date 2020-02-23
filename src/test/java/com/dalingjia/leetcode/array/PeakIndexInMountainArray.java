package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  852  山脉数组的峰顶索引
 * @Date 2019/9/17 下午9:10
 * @Version 1.0
 **/
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int temp = A[0];
        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > temp) {
                temp = A[i];
                index = i;
            }else {
                break;
            }
        }
        return index;
    }

}

 
    
    
    
    