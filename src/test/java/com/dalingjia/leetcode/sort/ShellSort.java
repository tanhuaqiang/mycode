package com.dalingjia.leetcode.sort;

/**
 * 希尔排序：
 *  
 */
public class ShellSort {

    /**
     * 针对有序序列在插入时采用交换法
     * @param arr
     * @return
     */
    private static int[] sort(int[] arr) {
        int length = arr.length;
        for (int gap = length/2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //插入排序采用交换法
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j -= gap;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = {56,62,47,21,26,76,11,39,76,18,33};
        ints = sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
