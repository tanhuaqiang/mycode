package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description LeetCode 476，数字的补数
 * @Date 2019/9/5 下午3:57
 * @Version 1.0
 **/
public class FindComplement {

    /**
     * 计算num的掩码，然后和num进行异或运算
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        int mask = 1;
        int temp = num;
        while (temp > 0) {
            temp = temp >> 1;
            mask = mask << 1;
        }
        //101 ^ 111
        return num ^ (mask - 1);
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}

 
    
    
    
    