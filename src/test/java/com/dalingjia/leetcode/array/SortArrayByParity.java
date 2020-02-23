package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 905 按奇偶排序
 * @Date 2019/9/18 下午12:31
 * @Version 1.0
 **/
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int index = 0;
        int index2 = A.length - 1;
        for (int i : A) {
            //采用双指针的方式，如果为偶数，就添加到开头，如果是奇数，就添加到尾部，无序考虑顺序
            if (i % 2 == 0) {
                res[index++] = i;
            } else {
                res[index2--] = i;
            }
        }
        return res;
    }
}
 
    
    
    
    