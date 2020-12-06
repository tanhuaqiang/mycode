package com.dalingjia.collection.list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dalingjia.bean.Student;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new String("javaEE"));
		list.add(new String("java"));
		list.add(new String("Android"));
		System.out.println(list);
		list.add(1, new String("Ajax"));//将当前处于该位置的元素（如果有的话）和所有后续元素向右移动（在其索引中加 1）。
		list.add(7, "python");
		System.out.println(list);
		
		list.remove(2);//删除索引为2的元素
		System.out.println(list);
		System.out.println(list.indexOf("Ajax"));
		list.set(1, "java");
		System.out.println(list);
		System.out.println(list.subList(0, 2));//返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图


		Collections.shuffle(list);
	}


	@Test
	public void test1(){
		String string = "183232,183232,198332,39323,93234,33344,33344";
		String[] strings = string.split(",");
		System.out.println(Arrays.asList(strings).contains("333443"));

		List secondList = Lists.newArrayList();
		if(CollectionUtils.isNotEmpty(Arrays.asList(strings))){
			System.out.println("急急急");
		}
	}

	@Test
	public void test2(){
		List<Integer> list = Lists.newArrayList(123, 3434, 212, 43423, 398, 980);
		List<Integer> temp = Lists.newArrayList(3434, 398, 980, 42);
		list.removeAll(temp);
		System.out.println(list);
	}

	@Test
	public void test3(){
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("aol", 21));
		list.add(new Student("gol", 19));
		System.out.println(JSON.toJSONString(list));
		System.out.println(list.toString());
	}

}
