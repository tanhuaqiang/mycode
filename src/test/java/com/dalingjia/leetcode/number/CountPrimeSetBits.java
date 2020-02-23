package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  762 二进制表示中质数个计算置位
 * @Date 2019/9/17 上午11:41
 * @Version 1.0
 **/
public class CountPrimeSetBits {

    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrimeSetBits(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimeSetBits(int i) {
        int t = 0;
        while (i > 0) {
            if ((i & 1) == 1) {
                t++;
            }
            i >>= 1;
        }
        //1 不是质数
        if (t == 1) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(t); j++) {
            if (t % j == 0) {
                return false;
            }
        }
        return true;
    }



    public int countPrimeSetBits2(int L, int R) {
        int count = 0;
        for(int i=L;i<=R;i++){
            if(isPrime(Integer.bitCount(i))){
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int x){
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }


    public static void main(String[] args) {
        //返回指定 int 值的二进制补码表示形式的 1 位的数量
        System.out.println(Integer.bitCount(6));
        System.out.println(Integer.bitCount(7));
        System.out.println(Integer.bitCount(8));
        System.out.println(Integer.bitCount(9));
    }
}

 
    
    
    
    