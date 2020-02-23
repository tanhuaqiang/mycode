package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  633 平方数之和
 * @Date 2019/9/7 下午9:56
 * @Version 1.0
 **/
public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            double n = Math.sqrt(c - i*i);
            if (n == (int)n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        double n = 9.1;
        System.out.println((int)n);
    }
}

 
    
    
    
    