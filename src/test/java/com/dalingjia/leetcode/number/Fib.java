package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  509 斐波拉契数
 * @Date 2019/9/5 下午9:15
 * @Version 1.0
 **/
public class Fib {

    public int fib(int N) {
        if (N == 1 || N == 0) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public int fib2(int N) {
        if (N == 1 || N == 0) {
            return N;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= N ; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

 
    
    
    
    