package com.dalingjia.leetcodeStudy;

public class Code7 {

    public static int reverse(int x) {
        int result = 0;
        int yu = 0;
        while (x / 10 != 0) {
            yu = x % 10;
            x = x / 10;

            result = result * 10 + yu;
        }


        return 0;
    }


    public static void main(String[] args) {

    }
}
