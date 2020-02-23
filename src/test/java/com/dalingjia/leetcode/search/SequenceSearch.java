package com.dalingjia.leetcode.search;

/**
 * 顺序查找：遍历整个数组
 */
public class SequenceSearch {


    private static int sequenceSearch(int[] arr, int key) {
        if(arr == null){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key){
                return 1;
            }
        }
        return -1;
    }
}
