package com.dalingjia.collection.list;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class SortTest {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		System.out.println(nums);
		
		Collections.reverse(nums);//反转集合
		System.out.println(nums); 
		
		Collections.sort(nums);//排序
		System.out.println(nums);
		
		Collections.shuffle(nums);//使用默认随机源对指定列表进行置换
		System.out.println(nums);

		List<String> list = Lists.newArrayList();
		list.add("xige");
		list.add("tanhq");
		list.add("fanjingling");
		list.add("laomao");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}

	@Test
	public void listToArray(){
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("bde");
		list.add("hhlj");

		list.add("abcer");
		list.add("dddefsg");
		list.add("bfffdesf");

		list.add("hhfdfdlj");
		System.out.println(list.subList(0,3));
		System.out.println(list.subList(3,6));
		System.out.println(list.subList(6,7));
	}


	private List<String> removeDuplicate(List<String> list) {
		LinkedHashSet<String> set = new LinkedHashSet<String>(list.size());
		set.addAll(list);
		list.clear();
		list.addAll(set);
		return list;
	}
}
