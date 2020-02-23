package com.dalingjia.leetcode.array;

import java.util.Arrays;

public class ReverseArrayTest {

    /**
     * 无论数组长度为奇数还是偶数，只需要将前半部分和后半部分对调即可
     * 0 1 2 3
     * 0 1 2 3 4
     * @param arr
     */
    private static Integer[] reverseArray(Integer[] arr){
        int temp=0;
        for (int i = 0; i < arr.length/2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i-1];
            arr[arr.length -i-1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,8,9,23,7,19,75};
        arr = reverseArray(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+"-");
//        }

        Arrays.asList(arr).stream().forEach( x -> System.out.print(x + ","));
    }
}
