package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  字符串相加
 * @Date 2019/8/22 下午8:30
 * @Version 1.0
 **/
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;          //进位位
        String result = "";
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                //低位相加
                carry += (num1.charAt(i--) - '0');
            }
            if (j >= 0) {
                carry += (num2.charAt(j--) - '0');
            }
            result = carry % 10 + result; //字符串拼接
            carry /= 10;//获取进位
        }
        //由于carry是进位位，所以carry只可能是0或1，这样写也行：carry != 0 ? 1 + result : result;
        return carry == 1 ? 1 + result : result;

    }

    public static void main(String[] args) {
        System.out.println(addStrings("673", "978672"));
    }

}

 
    
    
    
    