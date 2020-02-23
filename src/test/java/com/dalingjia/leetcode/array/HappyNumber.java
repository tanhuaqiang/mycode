package com.dalingjia.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tanhq
 * @Description 快乐数  判断出现的数之前有没有出现过，出现过就会产生循环，就不是快乐数。
 * @Date 2019/8/20 上午9:46
 * @Version 1.0
 **/
public class HappyNumber {
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<Integer>();
        while (n > 1) {
            set.add(n);
            n = convert(n);
            if (set.contains(n)) {
                return false;
            }
        }
        return true;
    }

    public int convert(int n) {
        int sum = 0;
        while (n > 0) {
            int a = n % 10;   //余数
            n = n / 10;       //商
            sum += a * a;
        }
        return sum;
    }
}

 
    
    
    
    