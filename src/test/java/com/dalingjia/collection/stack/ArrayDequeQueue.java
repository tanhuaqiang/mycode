package com.dalingjia.collection.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 模拟Queue队列
 */
public class ArrayDequeQueue {

	public static void main(String[] args) {

		Deque<String> queue = new ArrayDeque<String>();
		//依次将3个元素加入队列
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		System.out.println(queue);
		//访问，不poll元素
		System.out.println(queue.peek());
		System.out.println(queue);
		//poll元素
		System.out.println(queue.poll());
		System.out.println(queue);
		for(String s : queue){
			System.out.print(s + ",");
		}
	}
}
