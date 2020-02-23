package com.dalingjia.leetcode.number;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数 位与偶数的后面
 */
public class OddEvenNumber {

    /**
     * 快排调整数组奇数和偶数的顺序
     * @param arr
     * @return
     */
    public static void orderNumber(Integer[] arr){
        int firstNumber = 0;
        int lastNumber = arr.length - 1;
        if(arr == null || arr.length == 0){
            return;
        }
        while (firstNumber < lastNumber){
            //寻找第一个偶数
            while (firstNumber < lastNumber && !isEven(arr[firstNumber])){
                firstNumber++;
            }
            //寻找第一个奇数
            while (firstNumber < lastNumber && isEven(arr[lastNumber])){
                lastNumber--;
            }
            if(firstNumber < lastNumber){
                int temp = arr[firstNumber];
                arr[firstNumber] = arr[lastNumber];
                arr[lastNumber] = temp;
            }
        }
    }


    public static boolean isEven(Integer number){
        //&运算，全为1才为1
        return (number & 1) == 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 4, 1, 3, 6, 7};
//        orderNumber(arr);
        locationInvariant(arr);
        Arrays.asList(arr).stream().forEach(x -> System.out.println(x));
    }


    /**
     * 实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
     * @param arr
     */
    public static void locationInvariant(Integer[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        Integer[] newArr = new Integer[arr.length];
        int index = 0;
        //1,找出奇数
        for (int i = 0; i < arr.length; i++) {
            if(!isEven(arr[i])){
                newArr[index++] = arr[i];
            }
        }
        //2,找出偶数
        for (int i = 0; i < arr.length; i++) {
            if(isEven(arr[i])){
                newArr[index++] = arr[i];
            }
        }
        //3,用新数组替换旧数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }
}
