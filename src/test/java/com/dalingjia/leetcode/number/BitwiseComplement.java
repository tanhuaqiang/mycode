package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 1009 十进制整数的反码
 * @Date 2019/9/19 下午4:33
 * @Version 1.0
 **/
public class BitwiseComplement {

    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int sum = 0;
        int t = 1;
        while (N > 0) {
            int last = (N & 1);
            sum += (last == 1 ? 0 : 1) * t;
            t *= 2;
            N >>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(0>>1);
    }
}

 
    
    
    
    