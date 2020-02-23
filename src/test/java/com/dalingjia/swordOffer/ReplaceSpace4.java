package com.dalingjia.swordOffer;

public class ReplaceSpace4 {

	/**
	 * 题目描述：请实现一个函数，将字符串的每个空格替换为"%20"。
	 * 例如输入"We are happy.",则输出"We%20are%20happy."
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(replace("We are happy."));
		System.out.println(replace("We are  happy."));
		System.out.println(replace("We are  happy. "));
		System.out.println(replace(""));
		System.out.println(replace(" "));
		System.out.println(replace("     "));
		System.out.println(replace(null));
		System.out.println("".length());//0
		System.out.println(" ".length());//1
		System.out.println("   ".length());//3
	}
	
	public static String replace(String str){
		StringBuilder sb = new StringBuilder();
		if(str == null || str.length()==0){
			return null;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)==' ') {
				sb.append("%20");
//				sb.append("20");
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
	
}
