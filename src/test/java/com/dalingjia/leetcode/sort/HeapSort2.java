package com.dalingjia.leetcode.sort;

import java.util.Arrays;

/**
 * 堆排序：小顶堆
 */
public class HeapSort2 {


    private static void heapAdjust(int[] arr, int i, int length) {
        //当前结点左右孩子结点的下标
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        //三个结点中最大值的下标
        int min = i;
        if (left < length && arr[left] < arr[min]) {
            min = left;
        }
        if (right < length && arr[right] < arr[min]) {
            min = right;
        }
        //若i处节点值比左右孩子结点的值小，则与左右孩子最大的进行交换
        if (min != i) {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            //继续往下调整
            heapAdjust(arr, min, length);
        }
    }

    /**
     * 构建大顶堆，然后将最大值和最后一个节点进行交换
     *
     * @param arr
     */
    private static void heapSort(int[] arr) {
        int length = arr.length;
        //将数组看出完全二叉树，从第一个非叶子节点开始构造大顶堆
        int parent = (length - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapAdjust(arr, i, length);
        }

        //交换堆顶元素和堆最后一个节点, 减小堆的长度
        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //堆的个数已减一
            heapAdjust(arr, 0, i);
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        System.out.println("Input: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Output小顶堆: " + Arrays.toString(arr));

    }
}
