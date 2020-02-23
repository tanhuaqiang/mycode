package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 两整数之和
 * @Date 2019/8/21 下午9:37
 * @Version 1.0
 **/
public class GetSum {

    /**
     * 异或运算: 是非进位加法
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        //异或运算: 相同为0，不同为1,   0^0=0；  0^1=1；  1^0=1；   1^1=0；
        int result = a ^ b;
        int carry = (a & b) << 1;

        if (carry == 0) {
            return result;
        }
        return getSum(result, carry);
    }

    public static void main(String[] args) {
        System.out.println(getSum(3,2));
    }
}

 
    
    
    
    