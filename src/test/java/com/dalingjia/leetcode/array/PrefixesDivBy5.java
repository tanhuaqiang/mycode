package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description 1018 可被5整除的二进制前缀
 * @Date 2019/9/19 下午5:46
 * @Version 1.0
 **/
public class PrefixesDivBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>(A.length);
        int i = 0;
        int num = 0;
        while (i < A.length) {
            //num会出现大于Integer最大值的情况
            num = num * 2 + A[i];
            if (num % 5 == 0) {
                list.add(true);
            } else {
                list.add(false);
            }
            i++;
        }
        return list;
    }

    /**
     * 改进的方法：将余数作为num的新值
     * @param A
     * @return
     */
    public List<Boolean> prefixesDivBy52(int[] A) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            // 写成 num = (num<<1) + A[i]; 也是一样的效果
            num = num * 2 + A[i];
            num %= 5;
            answer.add(num == 0);
        }
        return answer;
    }

}

 
    
    
    
    