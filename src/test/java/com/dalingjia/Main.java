package com.dalingjia;

import java.util.Scanner;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2022/4/30 下午6:37
 * @Version 1.0
 **/
public class Main {

    public static int[][] method(int i, int[][] arr, int j) {
        j = j % 4;
        int[][] result = new int[i][i];
        if (j == 0) {
            return arr;
        } else if (j == 1) {
            for (int a = 0; a < i; a++) {
                for (int b = 0; b < i; b++) {
                    result[b][i - 1-a] = arr[a][b];
                }
            }
        } else if (j == 2) {
            for (int a = 0; a < i; a++) {
                for (int b = 0; b < i; b++) {
                    result[i-1-a][i-1-b] = arr[a][b];
                }
            }
        } else if (j == 3) {
            for (int a = 0; a < i; a++) {
                for (int b = 0; b < i; b++) {
                    result[a][i-1-b] = arr[a][b];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int[][] arr = new int[i][i];
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < i; b++) {
                arr[a][b] = sc.nextInt();
            }
        }
        int j = sc.nextInt();
        int[][] result = method(i, arr, j);
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < i; b++) {
                System.out.print(result[a][b] + " ");
            }
            System.out.println();
        }
    }
}

 
    
    
    
    