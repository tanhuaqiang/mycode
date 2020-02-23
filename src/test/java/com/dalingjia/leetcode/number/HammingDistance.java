package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 汉明距离
 * @Date 2019/9/1 上午11:51
 * @Version 1.0
 **/
public class HammingDistance {

    /**
     * 异或运算的作用
     * 　　参与运算的两个值，如果两个相应bit位相同，则结果为0，否则为1。
     * 　　0^0 = 0，
     * 　　1^0 = 1，
     * 　　0^1 = 1，
     * 　　1^1 = 0
     * 按位与运算符（&）
     * 运算规则：0&0=0;  0&1=0;   1&0=0;    1&1=1;
     *       即：两位同时为“1”，结果才为“1”，否则为0
     *
     * 右移运算符（>>）: 小数点不动，数字向右移动
     * 将一个数的各二进制位全部右移若干位，正数左补0，负数左补1，右边丢弃
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            int a = x & 1;
            int b = y & 1;
            if((a ^ b) == 1) {
                count++;
            }
            x >>= 1;
            y >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,6));

        //
        System.out.println(1 >> 2);
        System.out.println(4 >> 2);
    }
}

 
    
    
    
    