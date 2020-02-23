package com.dalingjia.leetcode.number;

public class UglyNumber {

    public static boolean isUglyNumber(int number){

        while (number%2 == 0){
            number = number / 2;
        }
        while (number%3 == 0){
            number = number / 3;
        }
        while (number%5 == 0){
            number = number / 5;
        }
        if(number == 1){
            return true;
        }
        return false;
    }

    public static int findUglyNumber(int number){

        int count = 0;
        int num = 0;
        while (true){
            if(isUglyNumber(++count)){
                num++;
                if(num == number){
                    break;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(findUglyNumber(20));
        isUglyNumber(84);
    }
}
