package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/9/19 下午5:26
 * @Version 1.0
 **/
public class CanThreePartsEqualSum {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int t = sum / 3;
        //找第一个分组
        int index = -1;
        for (int i = 0; i < A.length; i++) {
            if (t - A[i] == 0) {
                index = i;
                break;
            }else {
                t -= A[i];
            }
        }
        if (index == -1) {
            return false;
        }
        //找第二个分组
        int d = -1;
        t = sum/3;
        for (int i = index+1; i < A.length; i++) {
            if (t - A[i] == 0) {
                d = i;
                break;
            }else {
                t -= A[i];
            }
        }
        return d!= -1;
    }
}

 
    
    
    
    