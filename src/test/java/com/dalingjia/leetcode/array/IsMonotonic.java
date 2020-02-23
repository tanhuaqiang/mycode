package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 896 单调数列
 * @Date 2019/9/18 上午11:42
 * @Version 1.0
 **/
public class IsMonotonic {

    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        //记录大于和小于的值
        int[] ints = {0, 0};
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                ints[0]++;
            } else if (A[i] > A[i + 1]) {
                ints[1]++;
            }
            if (ints[0] > 0 && ints[1] > 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 本题就是不太好判断是增还是减还是都相等，所以，可以比较第一个元素和最后一个元素，然后就可以分为三种情况了
     *
     * @param A
     * @return
     */
    public boolean isMonotonic2(int[] A) {
        if (A[0] == A[A.length - 1]) {
            for (int i = 0; i < A.length - 1; i++) {
                if (A[0] != A[i]) {
                    return false;
                }
            }
        } else if (A[0] > A[A.length - 1]) {
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

 
    
    
    
    