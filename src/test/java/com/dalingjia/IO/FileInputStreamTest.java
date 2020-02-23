package com.dalingjia.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

public class FileInputStreamTest {

	/*@Test
	public void test(){
		//创建字节输入流，将文件输入到内存
		InputStream in = null;
		//创建字节输出流，用来保存文件
		OutputStream out = null;
		try {
			in = new FileInputStream("/Users/tanhq/Downloads/A要看的书2/springboot/src/main/java/com/dalingjia/bean/User.java");
			out = new FileOutputStream("copyFile.txt");
			//创建一个长度为1024个字节的数组来读取文件
			byte[] buffer = new byte[1024];
			//用于保存实际读取的字节数
			int hasRead = 0;
			//返回：读入缓冲区的总字节数
			while((hasRead = in.read(buffer,0,buffer.length)) > 0){
				*//**
				 * write(b, off, len) 的常规协定是：
				 * 		将数组 b中的某些字节按顺序写入输出流；
				 * 		元素 b[off] 是此操作写入的第一个字节，
				 * 		b[off+len-1] 是此操作写入的最后一个字节。 
				 * 必须从0开始，如果从别的数字开始，将导致IndexOutBoundException(数组角标越界)
				 * 		参数：
				 *			b - 数据。
				 *			off - 数据中的初始偏移量。
				 *			len - 要写入的字节数
				 *//*
				out.write(buffer, 0, hasRead);
				
				*//**
				 * 通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String
				 * 参数：
				 *		bytes - 要解码为字符的 byte
				 *		offset - 要解码的第一个 byte 的索引
				 *		length - 要解码的 byte 数 
				 *	总结：解码字节数组成字符串
				 *//*
				System.out.println(new String(buffer, 0, hasRead));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			*//**
			 * 程序打开的文件IO资源不属于内存里的资源，垃圾回收机制无法回收改资源，所以应该显示关闭文件IO资源
			 *//*
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}*/
}
