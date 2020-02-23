package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 1154 一年中的额第几天
 * @Date 2019/9/21 下午7:04
 * @Version 1.0
 **/
public class DayOfYear {

    public int dayOfYear(String date) {
        String[] str = date.split("-");
        int year = Integer.parseInt(str[0]);
        int months = Integer.parseInt(str[1]);
        int days = Integer.parseInt(str[2]);
        int[] table = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            table[1] = 29;
        }
        for (int i = 0; i < months-1; i++) {
            days += table[i];
        }
        return days;
    }



    public static void main(String[] args) {
        System.out.println(Integer.parseInt("03"));
    }
}

 
    
    
    
    