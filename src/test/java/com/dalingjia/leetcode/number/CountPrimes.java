package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 计算质数
 * @Date 2019/8/20 下午2:46
 * @Version 1.0
 **/
public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 如何论证这个结论呢，其实不难。首先 6x 肯定不是质数，因为它能被 6 整除；其次 6x+2 肯定也不是质数，因为它还能被2整除；
     * 依次类推，6x+3 肯定能被 3 整除；6x+4 肯定能被 2 整除。那么，就只有 6x+1 和 6x+5 (即等同于6x-1) 可能是质数了。
     * 所以循环的步长可以设为 6，然后每次只判断 6 两侧的数即可。
     *
     * @param num
     * @return
     */
    public boolean isPrimes(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(10));
    }


    /**
     * 第一次筛选2的倍数的数字，将其都筛选出去，第二轮筛选3的倍数的数字，筛选后，
     * 剩下的第一个数字就是5（因为4在第一次筛选的时候作为2的倍数已经筛出去）第三轮则筛选5倍数的数字，
     * 第四轮7倍数，第五轮11倍数……依次筛选下去，筛n轮
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int count = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(!flag[i]){
                count++;
                for (int j = 1; j*i < n; j++) {
                    flag[j*i] = true;
                }
            }
        }
        return count;
    }

}

 
    
    
    
    