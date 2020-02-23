package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  504 七进制数
 * @Date 2019/9/5 下午8:24
 * @Version 1.0
 **/
public class ConvertToBase7 {

    public String convertToBase7(int num) {
        String s = "";
        if (num == 0) {
            return "0";
        }
        int number = Math.abs(num);
        while (number > 0) {
            int yushu = number%7;
            number = number/7;
            s = yushu + s;
        }
        return num >= 0 ? s : "-" + s;
    }



    public static void main(String[] args) {
        System.out.println(Math.abs(-9));

    }
}

 
    
    
    
    