package com.dalingjia.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tanhq
 * @Description leetCode 20 有效的括号
 * @Date 2019/10/19 下午5:59
 * @Version 1.0
 **/
public class BracketsIsValid {

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
                //stack为空，或者栈顶元素不和字符c相等，返回false
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}()"));
    }
}

 
    
    
    
    