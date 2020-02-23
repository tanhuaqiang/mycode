package com.dalingjia.collection.stack;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		//栈的默认初始化容量为10
		System.out.println(stack.capacity());
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		System.out.println(stack);
		
		//获取栈顶元素，但不取出
		System.out.println(stack.peek());
		System.out.println(stack);
		//pop出第一个元素
		System.out.println(stack.pop());
		System.out.println(stack);
		//判断stack是否为空
		System.out.println(stack.empty());
		System.out.println(stack.capacity());//返回此向量的当前容量。 
		System.out.println(stack.size());//栈中元素的个数
	}
}
