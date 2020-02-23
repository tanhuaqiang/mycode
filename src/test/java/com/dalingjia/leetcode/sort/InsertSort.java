package com.dalingjia.leetcode.sort;

/**
 * 插入排序:
 *  我们经常选择序列的第一个元素作为有序序列（因为一个元素肯定是有序的），
 *  我们逐渐将后面的元素插入到前面的有序序列中，直到整个序列有序
 */
public class InsertSort {

    private static int[] insertSort(int[] array) {
        if(array == null){
            return null;
        }
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if(array[j] >= array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] ints = {56,62,47,21,26,76,11,39,76,18,33};
        ints = insertSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
