package com.dalingjia.test;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2022/5/31 下午5:08
 * @Version 1.0
 **/
public class AGB {

    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 3, 5, 3, 7};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }



}

 
    
    
    
    