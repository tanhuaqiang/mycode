package com.dalingjia.collection.myHashMap;

/**
 * 数组加链表的结构 jdk1.7
 */
public class HashMap implements Map {

	//默认容量16
	private final int DEFAULT_CAPACITY = 16;

	//扩容因子0.75
	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	//内部存储结构，数组
	Node[] table = new Node[DEFAULT_CAPACITY];

	//集合中元素实际个数
	private int size = 0;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 取值
	 */
	@Override
	public Object get(Object key) {
		//获取key的hash值
		int hashValue = hash(key);
		//求key所在数组的位置
		int index = indexFor(hashValue, table.length);
		for (Node node = table[index]; node != null ; node = node.next) {
			//hash值相同，key也相同，则返回该节点的value
			if (node.hash == hashValue && node.key.equals(key)) {
				return node.value;
			}
		}
		return null;
	}

	/**
	 * 存值
	 * 关于返回值：如果当前有一个相同的key，那么返回值是之前key对应的value,即oldValue
	 * 			如果是新的key，则返回null
	 * hashset中的add方法调用的是hashmap的put方法，通过判断put方法的返回值是否为空，
	 * 来保证hashset的值不重复
	 */
	@Override
	public Object put(Object key, Object value) {
		//获取key的hash值
		int hashValue = hash(key);
		//求key所在数组的位置
		int index = indexFor(hashValue, table.length);
		//index位置已经有数据了
		for(Node node = table[index]; node != null ; node = node.next){
			//链表中已有该key，则替换对应的value值，并将旧的oldValue返回
			if (node.hash == hashValue && node.key.equals(key)) {
				Object oldVaue = node.value;
				node.value = value;
				return oldVaue;
			}
		}
		/**
		 * 如果index位置没有数据，或是index位置有数据，但是不存在相同的key，则需要新增node
		 */
		addEntry(hashValue, key, value, index);
		//如果是新的key，则返回null
		return null;
	}

	public void addEntry(int hash, Object key, Object value, int i){
		//集合中元素增加时，若集合元素个数大于阀值，且对应数组下标不为空，则扩容
		if(size >= table.length * DEFAULT_LOAD_FACTOR ){
			//1，扩容
			resize(2 * table.length);
			hash = (null != key) ? hash(key) : 0;
			//2，找到新元素所在位置
			i = indexFor(hash, table.length);
		}
		//3，插入新元素
		createEntry(hash, key, value, i);
	}

	void createEntry(int hash, Object key, Object value, int i) {
		/*
		 * 当i位置为null时，将null作为新增node的下一个节点，新增node放在table[i]处，这样是没问题的
		 * 当i位置不为null时，将新增节点放在原始节点的前面，所以新增node的next指向原始i位置的node
		 * 所以2者结合起来，使用同一行代码
		 */
		Node node = table[i];//获取当前位置的node
		//生成一个新的node,并放到数组的index
		table[i] = new Node(hash, key, value, node);
		size++;
	}

	/**
	 * 扩容
	 * @param newCapacity
	 */
	private void resize(int newCapacity) {
		Node[] newTable = new Node[newCapacity];
		transfer(newTable, true);
		//table指向新的node数组
		table = newTable;
	}

	/**
	 * rehash元素到新的数组中
	 * @param newTable
	 * @param b
	 */
	private void transfer(Node[] newTable, boolean b) {
		int newCapacity = newTable.length;
		for (Node e: table) {
			while (e != null) {
				//1，先取下一个节点
				Node next = e.next;
				//2，确定元素的新位置
				int i = indexFor(e.hash, newCapacity);
				//3，将e放到新数组的头节点，下一个节点发生了变化，所以要先取下一个节点
				e.next = newTable[i];
				//4，头插法
				newTable[i] = e;
				//5，下一个节点
				e = next;
			}
		}
	}

	public int hash(Object key){
//		return key.hashCode();
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}


	public int indexFor(int hashValue, int length){

		return hashValue & (length - 1);
	}


}
