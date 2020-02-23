package com.dalingjia.collection.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ArrayDeque模拟栈
 */
public class ArrayDequeStack {

	public static void main(String[] args) {

		//模拟栈
		Deque<String> stack = new ArrayDeque<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");

		//访问，不pop出元素
		System.out.println(stack.peek());
		System.out.println(stack);
		//pop出元素
		System.out.println(stack.pop());
		System.out.println(stack);

		for(String string : stack){
			System.out.print(string);
		}
	}
}
