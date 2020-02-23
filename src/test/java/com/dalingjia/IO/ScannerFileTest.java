package com.dalingjia.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileTest {

	public static void main(String[] args) {
		
		Scanner sc = null;
		try {
			//Scanner读取文件
			sc = new Scanner(new File("E:/a.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}
}
