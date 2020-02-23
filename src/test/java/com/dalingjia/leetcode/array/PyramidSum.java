package com.dalingjia.leetcode.array;

/**
 * 小米笔试题：金字塔形数
 *      3      6     9     27   8
 *          9    15    36   35
 *            24    51   71
 *               75   122
 *                 197
 */
public class PyramidSum {

    private static int getPyramidSum(int[] arr) {
        for (int i = arr.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                arr[j] = arr[j] + arr[j + 1];
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 27, 8};
        System.out.println(getPyramidSum(arr));
    }
}
