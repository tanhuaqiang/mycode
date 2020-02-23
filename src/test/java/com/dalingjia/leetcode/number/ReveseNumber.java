package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description leetcode 7 反转整数
 * @Date 2019/10/19 下午3:53
 * @Version 1.0
 **/
public class ReveseNumber {

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 模拟数字出栈,求余数就OK了
            int yushu = x % 10;
            x = x / 10;
            //如果反转后整数溢出那么就返回 0
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && yushu > 7) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && yushu < -8) {
                return 0;
            }
            res = res * 10 + yushu;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

 
    
    
    
    