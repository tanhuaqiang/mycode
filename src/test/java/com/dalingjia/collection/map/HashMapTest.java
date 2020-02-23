package com.dalingjia.collection.map;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<Object,Object> map= new HashMap<Object,Object>();
		System.out.println(map.put("cs", "fsfs"));

		map.put("cs", "sssss");//覆盖操作
		map.put(null, "aaa");
		map.put(null, null);
		map.put("", "bbb");

		//map.entrySet()  返回此映射中包含的映射关系的 Set视图。
		for(Map.Entry<Object, Object> entry : map.entrySet()){
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
//		Integer.bitCount(length) == 1 : "length must be a non-zero power of 2"
		System.out.println(map.get("cs"));
		int h = 1;
		System.out.println(h >>> 20);
//		h ^= (h >>> 20) ^ (h >>> 12);
//		h = h ^ (h >>> 7) ^ (h >>> 4);
		System.out.println(map.remove("cs"));


		int number = 10;
		System.out.println(Integer.highestOneBit((number - 1) << 1));
	}


	@Test
	public void hashMapTest(){
		long star = System.currentTimeMillis();
		BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);
		for (int i = 0; i < 10000000; i++) {
			filter.put(i);
		}
		Assert.assertTrue(filter.mightContain(1));
		Assert.assertTrue(filter.mightContain(2));
		Assert.assertTrue(filter.mightContain(3));
		Assert.assertFalse(filter.mightContain(10000000));
		long end = System.currentTimeMillis();
		System.out.println("执行时间：" + (end - star));
	}

	@Test
	public void test1(){
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		map.put("d", "d");
		map.remove(map.keySet().iterator().next());
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

}
