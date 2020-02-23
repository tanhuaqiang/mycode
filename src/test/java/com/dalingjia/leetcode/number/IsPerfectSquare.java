package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  有效的完全平方数
 * @Date 2019/8/21 下午9:31
 * @Version 1.0
 **/
public class IsPerfectSquare {

    /**
     * 利用平方根和整数相同来计算
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        double result = Math.sqrt(num);
        return (result - (int)result) == 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(4) - (int)Math.sqrt(4));
    }


    /**
     * 所有的完全平方数都可以被表示成奇数和1+3+5+7+9 ...
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}

 
    
    
    
    