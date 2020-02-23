package com.dalingjia.leetcode.sort;

/**
 * 选择排序：每趟都找最小的数放在前面
 *  首先在末排序列中找到最小的元素，存放到排序序列的起始位置，然后，
 *  再从剩余未排序元素中继续寻找最小的元素，然后放到已排序序列的末尾
 */
public class SelectionSort {

    private static int[] selectSort(int[] ints) {
        if(ints == null){
            return null;
        }
        int length = ints.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                int temp = 0;
                if(ints[j] < ints[i]){
                    temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                 }
            }
        }
        return ints;
    }


    public static void main(String[] args) {
        int[] ints = {56,47,21,11};
        ints = selectSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
