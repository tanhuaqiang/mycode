package com.dalingjia.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {
		String[] strings = {"","fs","sfe"};
		List<String> list=Arrays.asList(strings);//将数组转换为list集合
		List<String> list2= new ArrayList<String>();
		
		System.out.println(strings.length);
		System.out.println(list.size());
		System.out.println(list2.size());
		System.out.println("₩");
	}
}
