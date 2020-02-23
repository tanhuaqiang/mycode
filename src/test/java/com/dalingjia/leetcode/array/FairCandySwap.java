package com.dalingjia.leetcode.array;

import java.util.HashSet;

/**
 * @author tanhq
 * @Description 888 公平的糖果交换
 * @Date 2019/9/18 上午10:27
 * @Version 1.0
 **/
public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sumA = 0;
        for (int i : A) {
            sumA += i;
        }
        int sumB = 0;
        for (int i : B) {
            sumB += i;
        }
        //差值的2分之1
        int sub = (sumA - sumB) / 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - B[j] == sub) {
                    res[0] = A[i];
                    res[1] = B[j];
                    return res;
                }
            }
        }
        return res;
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        HashSet<Integer> hashSet = new HashSet<>();
        int sumA = 0, sumB = 0;
        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            hashSet.add(b);
            sumB += b;
        }
        int tmp = (sumA - sumB) / 2;
        for (int a : A) {
            if (hashSet.contains(a - tmp)) {
                return new int[]{a, a - tmp};
            }
        }
        return null;


    }
}

 
    
    
    
    