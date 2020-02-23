package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  1137 第N个泰波那契数
 * @Date 2019/9/21 下午6:52
 * @Version 1.0
 **/
public class Tribonacci {

    public int tribonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public int tribonacci2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int t1 = 0;
        int t2 = 1;
        int t3 = 1;
        int res = 0;
        for (int i = 3; i <= n ; i++) {
            res = t1 + t2 + t3;
            t1 = t2;
            t2 = t3;
            t3 = res;
        }
        return res;
    }
}

 
    
    
    
    