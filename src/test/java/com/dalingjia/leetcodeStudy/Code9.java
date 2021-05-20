package com.dalingjia.leetcodeStudy;

/**
 * 回文数
 */
public class Code9 {

    /**
     * 第一，负数或者整数如果末尾有0的（整数本身就是0除外），则必定不是回文数
     * 第二，不需要将整个整数完全反转，只需要反转一半即可，整数的位数有可能是偶数有可能是奇数，
     * 在return返回结果的时候，将这两种情况都考虑进来即可
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        /**
         * y == x 是位数为偶数
         * y/10 == x 位数为奇数
         */

        return y == x || y / 10 == x;
    }


    public static void main(String[] args) {

    }
}
