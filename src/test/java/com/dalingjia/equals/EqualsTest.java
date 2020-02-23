package com.dalingjia.equals;

public class EqualsTest {

	public static final int INT1 = 9;  
	public static final int INT2 = 9;  
	public static final int INT3 = 9; 
	
	public static void main(String[] args) {
		// ==号在比较基本数据类型时比较的是值，而用==号比较两个对象时比较的是两个对象的地址值
		// 在所有没有重写equals()方法的类中，调用equals()方法其实和使用==号的效果一样，也是比较的地址值
		int x = 10;
		int y = 10;
		String str1 = new String("abc");
		String str2 = new String("abc");
		String str3 = "abc"; //创建对象abc时，如果常量池中没有，就在常量池中创建一个abc对象
		String str4 = "abc"; //第二次创建时，发现常量池中有，就将引用直接指向abc     str3和str4都在栈中
		
		System.out.println(x == y); // 输出true
		System.out.println(str1 == str2); // 输出false
		System.out.println(str1.equals(str2)); // 输出true
		System.out.println(str1.equals(str3)); // 输出true
		System.out.println(str3==str4);// 比较的是对象的地址值，都在常量池中，输出true
		System.out.println(str3.equals(str4));// 输出true
		
		Student student1 = new Student("tanhq");
		Student student2 = new Student("tanhq");
		System.out.println(student1==student2); // 输出false
		System.out.println(student1.equals(student2));//在所有没有重写equals()方法的类中，调用equals()方法其实和使用==号的效果一样，也是比较的地址值
		System.out.println("hashCode = " + student2.hashCode());
		
		
	}
}
