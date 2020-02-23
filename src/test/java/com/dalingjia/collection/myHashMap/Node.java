package com.dalingjia.collection.myHashMap;

/**
 * 数组中的元素结点
 * @author tanhq
 *
 */
public class Node implements Map.Entry{

	int hash;
	Object key;
	Object value;
	Node next;//下一个结点


	public Node(int hash, Object key, Object value, Node next) {
		super();
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}

	@Override
	public Object getKey() {
		return key;
	}

	@Override
	public Object getValue() {
		return value;
	}
}
