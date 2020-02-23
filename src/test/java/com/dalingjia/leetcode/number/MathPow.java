package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 美团一面算法题
 * @Date 2019/11/21 下午6:36
 * @Version 1.0
 **/
public class MathPow {

    public double myPow(double x, int n) {
        if (x == 0 && n == 0) {
            throw new IllegalArgumentException();
        }
        // 指数正负标记
        boolean isNegative = false;
        // 求n的绝对值
        if (n < 0) {
            n = -n;
            isNegative = true;
        }
        double result = pow(x, n);
        if (isNegative) {
            return 1.0 / result;
        } else {
            return result;
        }
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double result = pow(x, n / 2);
            // n是奇数
            if (n % 2 != 0) {
                return x * result * result;
            } else {
                return result * result;
            }
        }
    }


    public static void main(String[] args) {
        MathPow pow = new MathPow();
        pow.myPow(5, 4);
    }
}

 
    
    
    
    