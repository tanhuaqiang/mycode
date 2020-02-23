package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  941 有效的山脉数组
 * @Date 2019/9/18 下午6:39
 * @Version 1.0
 **/
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        //找到最大的数
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        //最大值不能头和尾数
        if (maxIndex == 0 || maxIndex == A.length - 1) {
            return false;
        }
        //前半段递增
        for (int i = 0; i < maxIndex; i++) {
            if (A[i] >= A[i + 1]) {
                return false;
            }
        }
        //后半段递减
        for (int i = maxIndex; i < A.length -1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

 
    
    
    
    