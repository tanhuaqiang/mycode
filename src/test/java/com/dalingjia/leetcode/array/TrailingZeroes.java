package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 阶层后的零
 * @Date 2019/8/8 下午9:29
 * @Version 1.0
 **/
public class TrailingZeroes {


    /**
     * 要求末尾有多少个零，则该数应为x*10k 的形式等于x*（2k *5k）
     *
     * 也就是求该数分解质因子后有几个5就行，：如1*2*3*4*5=1*2*3*2*2*5（里面有一个5）所以结果为1个0
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n /5;
            //除5后，剩余乘积还有5，需要继续判断
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        TrailingZeroes t = new TrailingZeroes();
        System.out.println(t.trailingZeroes(30));
    }
}

 
    
    
    
    