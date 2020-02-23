package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 数字转换为十六进制数
 * @Date 2019/8/22 下午5:36
 * @Version 1.0
 **/
public class ToHex {

    char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * >>> 表示不带符号向右移动二进制数，移动后前面统统补0；
     * >>  表示带符号移动，
     * @param num
     * @return
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String result = "";
        while (num != 0) {
            //0xF: 1111
            result = chars[(num & 0xF)] + result;
            num >>>= 4;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

 
    
    
    
    