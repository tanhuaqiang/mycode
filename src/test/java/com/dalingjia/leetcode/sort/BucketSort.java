package com.dalingjia.leetcode.sort;

/**
 * 桶排序
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] integer = new int[]{8, 2, 5, 4, 6, 2, 7, 1};
        int[] integers = new int[11];//用来存放1~10
        //把数组里的数放到对应数组角标里
        for (Integer i : integer){
            integers[i]++;
        }
        //打印
        for (int i = 0; i < integers.length; i++) {
            if(integers[i] != 0){
                for (int j = 0; j < integers[i]; j++) {
                    System.out.print(i + ",");
                }
            }
        }
    }
}
