package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  第N个数字
 * @Date 2019/8/22 下午12:06
 * @Version 1.0
 **/
public class FindNthDigit {

    public static int findNthDigit(int n) {
        int len = 1;        //用于记录所在数字的位数
        int start = 1;      //n所在的数字的起始值
        long tem = 9;
        while (n > len * tem) {
            n -= len * tem;     //减去低位的数的个数
            len++;
            tem *= 10;
            start *= 10;
        }
        start += (n - 1) / len;     //找到所在的那个数
        String num = String.valueOf(start);
        char c = num.charAt((n - 1) % len); //n所在数字的那个数字, 确定具体在第几位
        return c - '0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(200));
        System.out.println(findNthDigit(201));
        System.out.println(findNthDigit(2147483647));
    }
}

 
    
    
    
    