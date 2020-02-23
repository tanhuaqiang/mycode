package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 各位相加
 * @Date 2019/8/21 上午10:25
 * @Version 1.0
 **/
public class AddDigits {

    public int addDigits(int num) {
        while (num >= 10) {
            num = convert(num);
        }
        return num;
    }

    private int convert(int num) {
        int result = 0;
        while (num > 0) {
            int yushu = num % 10;
            num /= 10;
            result += yushu;
        }
        return result;
    }


    public int addDigits2(int num) {

        return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
    }

}

 
    
    
    
    