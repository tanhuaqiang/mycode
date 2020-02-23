package com.dalingjia.leetcode.search;

/**
 * 插值查找
 */
public class InterpolationSearch {

    private static int search(int[] array, int key) {
        int low = 0;
        int high = array.length-1;
        int mid = 0;
        while (low <= high) {
            //取整操作
            mid = low + (key - array[low]) / (array[high] - array[low]) * (high - low);
            if(key == array[mid]){
                return mid;
            }else if(key < array[mid]){
                high = mid-1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int key = 8;
        System.out.println(search(arr, key));
    }
}
