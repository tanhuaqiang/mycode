package com.dalingjia.leetcode.search;

/**
 * 二分查找
 */
public class BinSearch {

    /**
     * 非递归查找，数组元素不重复
     * @param arr
     * @param key
     * @return
     */
    private static int binSearch(int[] arr, int key) {
        //定义每次查找数组的最低位和最高位
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }
        while (low <= high) {
            mid = (low + high)/2;
            if(arr[mid] == key){
                return mid;
                //比关键字小则关键字在右区域
            }else if(arr[mid] < key){
                low = mid + 1;
            }else {
                //比关键字大则关键字在左区域
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 数组元素重复，查找第一个元素出现的位置
     * @param arr
     * @param key
     * @return
     */
    private static int binSearch1(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }
        while (low < high) {
            mid = (low + high)/2;
            if(arr[mid] < key){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        if(arr[low] != key){
            return -1;
        }else {
            return low;
        }

    }

    public static void main(String[] args) {
//        int[] arr = {1,3,5,7,9,11};
        int[] arr = {3,3,5,5,7,7,9,11};
        int key = 3;
        System.out.println(binSearch1(arr, key));
    }
}
