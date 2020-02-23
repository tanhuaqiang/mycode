package com.dalingjia.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 问题描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。假设压入栈的所有数字均不相等。
 * 例如序列1/2/3/4/5是某栈的压栈序列，序列4/5/3/2/1是该压栈序列对应的一个弹出序列，但4/3/5/1/2就不可能是该压栈序列的弹出序列
 *
 */
public class IsPopOrder {

    /**
     * 思路：循环arr2，让arr1入栈的同时和arr2进行比较，相同则出栈，
     *      继续向下比较，同时要注意栈中元素是否为空
     * @param arr1 ：入栈顺序
     * @param arr2 ：出栈顺序
     * @return
     */
    public static boolean isPopOrder(int[] arr1, int[] arr2){
        if(arr1 == null || arr2 == null){
            return false;
        }
        int point = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr2.length; i++) {
            //栈中不为空，且栈顶元素和arr2的第i个元素相同，则出栈
            if(!stack.isEmpty() && stack.peek() == arr2[i]){
                stack.pop();
            }else {
                //检查完所有元素也不是，返回false
                if (point == arr1.length){
                    return false;
                }else {
                    do {
                        stack.push(arr1[point++]);
                    }while (stack.peek() != arr2[i] && point != arr1.length);
                    if(stack.peek() == arr2[i]){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder(arr1, arr2));
    }
}
