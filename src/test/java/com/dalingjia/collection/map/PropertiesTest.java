package com.dalingjia.collection.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.setProperty("username", "tanhq");
		props.setProperty("password", "123");
		//将properties的key-value存储到E:/a.properties
		props.store(new FileOutputStream("E:/a.properties"), "comment line");
		
		Properties props2 = new Properties();
		props2.setProperty("gender", "male");
		props2.load(new FileInputStream("E:/a.properties"));
		//map自动调用toString()方法
		System.out.println(props2);
	}
}
