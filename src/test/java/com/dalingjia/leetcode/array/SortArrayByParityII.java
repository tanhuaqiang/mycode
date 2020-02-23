package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  922 按奇偶排序数组II
 * @Date 2019/9/18 下午4:00
 * @Version 1.0
 **/
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int[] ints = new int[A.length];
        int i = 0;
        int j = 1;
        for (int k = 0; k < A.length; k++) {
            //偶数
            if (A[k] % 2 == 0) {
                ints[i] = A[k];
                i += 2;
            }else {
                ints[j] = A[k];
                j += 2;
            }
        }
        return ints;
    }
}

 
    
    
    
    