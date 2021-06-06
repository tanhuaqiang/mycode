package com.dalingjia.leetcodeStudy;

import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class Code20 {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new java.util.HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty() && map.get(stack.peek()) != null && map.get(stack.peek()) == chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        //foreach遍历
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {    //如果为（ { [则进栈
                stack.push(c);
            } else {
                if (stack.empty()) return false;    //栈为空 所以返回false
                if (c == ')' && stack.pop() != '(') return false;    //有) 但没有左边的相匹配 所以返回false
                if (c == ']' && stack.pop() != '[') return false;    //有]但没有左边的相匹配 所以返回false
                if (c == '}' && stack.pop() != '{') return false;    //有}但没有左边的相匹配 所以返回false
            }
        }
        return stack.empty();    //根据else中栈是否为空的情况返回 true/false

    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
}
