package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 3的幂
 * @Date 2019/8/21 下午4:12
 * @Version 1.0
 **/
public class IsPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            int t = n % 3;
            if (t != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        if (n < 1) {
            return false;
        }
        //返回 double 值的底数为 10 的对数
        double tem = Math.log10(n) / Math.log10(3);
        return (tem - (int) tem == 0) ? true : false;
    }

    public static void main(String[] args) {
        double a = 9.2;
        int b = 9;
        System.out.println(a == b);
        System.out.println((int) a);
    }


    /**
     * 4的幂
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        double a = Math.log10(num) / Math.log10(4);
        return (a - (int) a == 0) ? true : false;
    }
}

 
    
    
    
    