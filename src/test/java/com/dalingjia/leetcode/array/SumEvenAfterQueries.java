package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  985 查询后的偶数和
 * @Date 2019/9/19 下午12:03
 * @Version 1.0
 **/
public class SumEvenAfterQueries {

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            A[queries[i][1]] = queries[i][0] + A[queries[i][1]];
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] % 2 == 0) {
                    sum += A[j];
                }
            }
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(-2 % 2 == 0);
        int[] A = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        sumEvenAfterQueries(A, queries);

    }
}

 
    
    
    
    