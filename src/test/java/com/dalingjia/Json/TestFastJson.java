package com.dalingjia.Json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/* 测试fastjson
 * @author tanhq
 * 2018年7月1日
 */
public class TestFastJson {

    public static void main(String[] args) {
		
		// 1. 将集合或者对象转换成json字符串
		Person p1 = new Person(1, "tanhq");
		Person p2 = new Person(2, "jiese");
		
		System.out.println("对象转换成json字符串 ：" + JSON.toJSON(p1));
		
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		System.out.println("集合转换成json字符串 ： " + JSON.toJSONString(list));
		System.out.println("集合转换成json字符串 ： " + JSON.toJSON(list));

		//2.  Json串反序列化成对象
		Person p3 = JSON.parseObject("{\"id\":4,\"name\":\"liyang\"}", Person.class);
		System.out.println("Json串反序列化成对象 : id: " + p3.getId() + " name :" + p3.getName());
	
		// Json串反序列化成数组
		List<Person> persons = JSON.parseArray("[{\"id\":5,\"name\":\"qiaodan\"},{\"id\":6,\"name\":\"kebi\"}]", Person.class);
		for (Person person : persons) {
			System.out.println("Json串反序列化成数组: " + person);
		}
	}
}
