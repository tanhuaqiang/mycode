package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 位1的个数
 * @Date 2019/8/9 上午11:55
 * @Version 1.0
 **/
public class NumberOf1 {

    /**
     * 只适用于正数
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            //与运算：同为1结果为1，否则为0
            if ((n & 1) == 1) {
                count++;
            }
            //右移一位：相当于除2操作
            n = n >> 1;
        }
        return count;
    }

    /**
     * 负数也使用
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        int flag = 1;
        for (int i = 0; i < 32; i++) {
            //与运算：同为1结果为1，否则为0
            if ((n & flag) == flag) {
                count++;
            }
            //左移一位：继续判断高位是否为1
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1 numberOf1 = new NumberOf1();
        System.out.println(numberOf1.tenToBinary(10));
        System.out.println(Integer.toBinaryString(10));


        System.out.println(numberOf1.binaryToTen("1010"));
        System.out.println(Integer.valueOf("1010", 2));

    }


    /**
     * 十进制数转二进制数
     *
     * @param n
     * @return
     */
    public String tenToBinary(int n) {
        String result = "";
        while (n > 0) {
            char c = (char) (n % 2 + '0');
            n = n / 2;
            result = c + result;
        }
        return result;
    }

    /**
     * 二进制数转十进制数
     *
     * @param s
     * @return
     */
    public int binaryToTen(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 2 + s.charAt(i) - '0';
        }
        return result;
    }
}

 
    
    
    
    