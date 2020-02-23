package com.dalingjia.leetcode.number;

import java.util.*;

/**
 * @author tanhq
 * @Description 970 强整数
 * @Date 2019/9/18 下午10:54
 * @Version 1.0
 **/
public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        //防止出现重复的值
        Set<Integer> res = new HashSet();
        //i的值不能大于bound
        for (int i = 1; i < bound; i *= x) {
            //j + i <= bound 是取值条件
            for (int j = 1; j + i <= bound; j *= y) {
                res.add(j + i);
                //y== 1 没必须继续下去
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }

        }
        return new ArrayList(res);
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));
    }
}

 
    
    
    
    