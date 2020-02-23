package com.dalingjia.swordOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 定义链表结构
 * @author tanhq
 */
class LinkNode{
	LinkNode nextLinkNode;
	int node_value;
	public LinkNode getNextLinkNode() {
		return nextLinkNode;
	}
	public void setNextLinkNode(LinkNode nextLinkNode) {
		this.nextLinkNode = nextLinkNode;
	}
	public int getNode_value() {
		return node_value;
	}
	public void setNode_value(int node_value) {
		this.node_value = node_value;
	}
	
}

public class PrintListReverse5 {

	/**
	 * 题目描述：输入一个链表的头结点，从尾到头反过来打印出每个结点的值.
	 * @param args
	 */
	//反转函数,利用Stack来解决
	public static void reverse(LinkNode headNode){
		//Stack是古老的集合，性能较差，推荐使用ArrayDeque,既可以模拟栈，又可以模拟队列
//		Stack<LinkNode> stack = new Stack<LinkNode>();
		Deque<LinkNode> deque = new ArrayDeque<LinkNode>();
		while (headNode != null) {
			deque.push(headNode);
			headNode = headNode.getNextLinkNode();
		}
		while (!deque.isEmpty()) {
			System.out.println(deque.pop().getNode_value());
		}
	}
	
	public static void main(String[] args) {
		//定义链表的3个结点
		LinkNode node1 = new LinkNode();
		LinkNode node2 = new LinkNode();
		LinkNode node3 = new LinkNode();
		//3个结点的值
		node1.setNode_value(1);
		node2.setNode_value(2);
		node3.setNode_value(3);
		//结点1,2的下一个结点
//		node1.nextLinkNode = node2;
//		node2.nextLinkNode = node3;
		node1.setNextLinkNode(node2);
		node2.setNextLinkNode(node3);
		reverse(node1);
	}
}
