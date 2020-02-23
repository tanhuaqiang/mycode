package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 1089 复写零
 * @Date 2019/9/20 下午9:49
 * @Version 1.0
 **/
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int[] ints = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                ints[index++] = 0;
                //0，0，0，0，0 防止越界
                if (index >= arr.length) {
                    break;
                }
                ints[index++] = 0;
            } else {
                ints[index++] = arr[i];
            }
            if (index >= arr.length) {
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ints[i];
        }
    }

    public void duplicateZeros2(int[] arr) {
        int zeroCnt = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {
                zeroCnt++;
            }
        }
        int j = size + zeroCnt;
        for (int i = size - 1; i >= 0; i--) {
            if (--j < size) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0 && --j < size) {
                arr[j] = 0;
            }
        }
    }
}

 
    
    
    
    