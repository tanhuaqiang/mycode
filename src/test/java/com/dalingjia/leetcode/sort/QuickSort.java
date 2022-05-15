package com.dalingjia.leetcode.sort;

/**
 * 快速排序（快排）
 * 1，时间复杂度：
 * 最坏情况下，时间复杂度是O(n^2);
 * 最优情况下，时间复杂度是O(nlogn);
 * 平均时间复杂度是O(nlogn);
 *
 * 2，空间复杂度：O(logn)
 */
public class QuickSort {

    /**
     *
     * @param arr       需要排序的数组
     * @param left      数组第一个数
     * @param right     数组最后一个数
     */
    public static void quickSort(int[] arr, int left , int right){
        int i = 0;      //哨兵i所处的位置
        int j = 0;      //哨兵j所处的位置
        int mark = 0;   //基准数

        if(left >= right){
            return;
        }
        i = left;
        j = right;
        mark = arr[left];
        //当i<j说明没有相遇
        while (i < j){
            while (i < j && arr[j] >= mark){
                j--;
            }
            while (i < j && arr[i] <= mark){
                i++;
            }
            //哨兵i,j没有相遇，且分别找到大于和小于基准数的数，进行交换
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //当i==j说明已经相遇，和基准数进行交换
        arr[left] = arr[i];
        arr[i] = mark;
        //递归排列子数组
        quickSort(arr, left, i - 1);
        quickSort(arr, i+1, right);
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2 ,7 ,9 ,3 ,4 ,5 ,10 ,8};
        quickSort(arr, 0, arr.length-1);
        for (int i : arr){
            System.out.print(i + ",");
        }
    }
}
