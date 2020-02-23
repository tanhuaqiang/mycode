package com.dalingjia.collection.myHashMap;

import org.junit.Test;

public class TestMyHashMap {

	public static void main(String[] args) {
		//每个java类都需要至少有一个构造方法，所以对于代码里没有构造方法的，就自动生成一个无参的
		HashMap hashMap=new HashMap();
        hashMap.put("aaa", "1111");
        hashMap.put("bbb", "2222");
        hashMap.put("ccc", "3333");
        hashMap.put("ddd", "4444");
        hashMap.put("eee", "5555");
        hashMap.put("fff", "6666");
        hashMap.put("ggg", "7777");
        hashMap.put("hhh", "9999");
        hashMap.put("iii", "0000");
        hashMap.put("jjj", "1231");
        hashMap.put("kkk", "9234");
        hashMap.put("lll", "4525");
        hashMap.put("mmm", "6234");
        hashMap.put("nnn", "8353");
        hashMap.put("ooo", "8353");
        hashMap.put("ppp", "8353");
        System.out.println(hashMap.get("ccc"));
        System.out.println(hashMap.get("ddd"));
	}

	@Test
    public void method(){
        Integer[] integers = new Integer[10];
        integers[4] = 9;
        System.out.println(integers.length);
    }
}
