package com.dalingjia.leetcode.array;

public class MoreThanHalfNum {

    public static int findMoreThanHalNum(int[] arr){
        int temp = 0;
        int num = 0;
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            num = arr[i];
            array[num] += 1;
            if(array[num] > arr.length/2){
                temp = num;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,5,4,2};
        System.out.println(findMoreThanHalNum(arr));
    }
}
