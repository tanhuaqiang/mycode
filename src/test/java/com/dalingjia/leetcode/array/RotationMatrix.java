package com.dalingjia.leetcode.array;

import java.util.ArrayList;

/**
 * @author tanhq
 * @Description 二维数组
 * @Date 2022/5/28 下午8:31
 * @Version 1.0
 **/
public class RotationMatrix {


    /**
     * 行列转换
     * int[][] a = { { 1, 2, 3 },
     * { 4, 5, 6 },
     * { 7, 8, 9 } }
     *
     * @param array
     */
    public static int[][] rowColumnConver(int[][] array) {
        //行数
        int n = array.length;
        //列数
        int m = array[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = array[i][j];
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.println(result[i][j] + " ");
//            }
//        }
        return result;
    }

    /**
     * 顺时针旋转90度
     *
     * @param array
     * @return
     */
    private static int[][] rotate(int[][] array) {
        int n = array.length;
        int m = array[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //顺时针旋转90度
                res[j][m - 1 - i] = array[i][j];
                //逆时针旋转90度
//                res[m-1-j][i] = array[i][j];
            }
        }
        return res;
    }

    /**
     * 顺时针打印二维数组
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;

    }

    public static void main(String[] args) {
        int[][] b = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
//                    {13, 14, 15, 16}};
        System.out.println(spiralOrder(b));

        int[][] a = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        rowColumnConver(a);
        System.out.println(spiralOrder(a));
    }
}

 
    
    
    
    