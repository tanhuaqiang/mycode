package com.dalingjia;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2022/6/14 下午3:34
 * @Version 1.0
 **/
public class Testddd {


    public static void main(String[] args) {
//        int[][] num1 = new int[][];

    }


    /**
     * a1=[[1,2,3],
     * [1,2,3]]
     *
     * a2=[[1,2],
     * [1,2],
     * [1,2]]
     *
     * a1*a2=[[6,12],
     * [6,12]
     * ]
     * @param arr1
     * @param arr2
     */
    private static int[][] method(int[][] arr1, int[][] arr2) {
        int hang = arr1.length;
        int lie = arr2[0].length;
        int[][] result = new int[hang][lie];
        int t = 0;
        for (int i = 0; i < hang; i++) {
            int temp = 0;

            for (int j = 0; j < lie; j++) {
                temp += arr1[i][j] * arr2[j][i];

            }
            result[i][t++] = temp;

        }
        return result;

    }
}

 
    
    
    
    