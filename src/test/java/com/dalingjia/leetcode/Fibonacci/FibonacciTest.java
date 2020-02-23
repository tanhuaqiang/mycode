package com.dalingjia.leetcode.Fibonacci;

public class FibonacciTest {

    private static int fibonacci1(int i){
        if(i <= 0){
            return 0;
        }
        if(i ==1 || i==2){
            return 1;
        }else {
            return fibonacci1(i - 1) + fibonacci1(i - 2);
        }
    }


    public static void main(String[] args) {
        System.out.println(fibonacci1(0));
        System.out.println(fibonacci1(1));
        System.out.println(fibonacci1(2));
        System.out.println(fibonacci1(3));
        System.out.println(fibonacci1(4));
        System.out.println(fibonacci1(5));
        System.out.println(fibonacci1(6));
        System.out.println(fibonacci1(7));
        System.out.println(fibonacci1(8));
        System.out.println(fibonacci1(9));
    }
}
