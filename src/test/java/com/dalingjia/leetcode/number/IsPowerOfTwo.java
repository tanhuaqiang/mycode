package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 2的幂
 * @Date 2019/8/20 下午7:25
 * @Version 1.0
 **/
public class IsPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
    }
    public static boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }


}

 
    
    
    
    