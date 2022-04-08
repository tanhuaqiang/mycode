package com.dalingjia.pattern.ProxyPattern;

public class BigImageTest {
 
	public static void main(String[] args) {
		System.out.println("使用代理");
		//null,确保每次调用show方法需要示例化BigImage
		Image image=new ImageProxy(null);
		System.out.println("开始显示图片");
		image.show();
		System.out.println("***************************************");
		System.out.println("没使用代理");
		Image image2=new BigImage();
		image2.show();
	}
}