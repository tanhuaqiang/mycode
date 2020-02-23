package com.dalingjia.collection.map;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.Properties;

public class SystemTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Map<String,String> env = System.getenv();

		for (String name : env.keySet()) {
			System.out.println(name + "\t-->\t" + env.get(name));
		}
		
		System.out.println(System.getenv("JAVA_HOME"));
		
		Properties props = System.getProperties();
		//将props的key-value存储到D:\workspace\CodeTest\props.txt(当前项目所在目录下)
		props.store(new FileOutputStream("props.txt"), "System Properties");
		
		System.out.println(System.getProperty("os.name"));
		
	}
}
