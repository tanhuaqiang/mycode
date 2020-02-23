package com.dalingjia.IO;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		File file = new File(".");
		System.out.println(file.getName());
		System.out.println(file.getParent());//null
		System.out.println(file.getAbsolutePath());//D:\workspace\ssmybatis\.
		System.out.println(file.getAbsoluteFile());//D:\workspace\ssmybatis\.
		System.out.println(file.getAbsoluteFile().getParent());
		
		/**
		 * 在当前路径下创建一个临时文件
		 * prefix - 用于生成文件名的前缀字符串；必须至少是三字符长
		 * suffix - 用于生成文件名的后缀字符串；可以为 null，在这种情况下，将使用后缀 ".tmp"
		 * directory - 将创建的文件所在的目录；如果使用默认临时文件目录，则该参数为 null 
		 */
		File tempFile = null;
		 try {
			tempFile = File.createTempFile("aaa", ".txt", file);
			System.out.println(tempFile.getAbsolutePath());
			//指定jvm退出时删除改文件
			tempFile.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		File newFile = new File(System.currentTimeMillis()+"");
		System.out.println("newFile对象是否存在："+newFile.exists());
		System.out.println(newFile.getAbsolutePath());
	}
}
