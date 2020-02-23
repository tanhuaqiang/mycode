package com.dalingjia.leetcode.number;

public class BinaryNumber {

    /**
     * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制是1001，有2位是1 因此如果输入9，该函数输出2
     */

    public static int getNumber(int number){
        int i = 0;
        while (number > 0){
            //求余数
            if(number % 2 == 1){
                i++;
            }
            number = number / 2;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(getNumber(8));
        System.out.println(getNumber(9));
        System.out.println(getNumber(10));
        System.out.println(getNumber(11));
        System.out.println(getNumber(19));
        System.out.println(getNumber(28));
        System.out.println(getNumber(31));
    }
}
