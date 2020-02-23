package com.dalingjia.LambdaStream;

interface Eatable {
	void taste();
}
interface Flyable{
	void fly(String weather);
}
interface Addable{
	int add(int a, int b);
}


/**
 * Lambda表达式只能实现一个方法，因此他只能为只有一个抽象方法的接口（函数式接口）创建对象
 * 函数式接口：只有一个抽象方法的接口
 * Lambda表达式的目标类型必须是一个明确的函数式接口
 * @author tanhq
 *
 */
public class LambdaQs {
	public void eat(Eatable e){
//		System.out.println(e);
		e.taste();//调用的是接口实现类重写的方法
	}
	public void drive(Flyable f){
//		System.out.println("我正在驾驶："+f);
		f.fly("碧空如洗的晴日！");//调用的是接口实现类重写的方法
	}
	public void test(Addable add){
		System.out.println("5和3的和为："+add.add(3, 5));
	}
	
	public static void main(String[] args) {
		LambdaQs lq = new LambdaQs();
		/*
		 * Lambda表达式的主要作用就是 代替匿名内部类(匿名内部类是接口的实现类，并重写的接口的抽象方法)的烦琐语法
		 * 三部分组成：
		 * 	形参列表：重写方法的形参,允许省略参数的类型
		 * 	箭头：->
		 * 	代码块：重写方法的具体内容
		 */
		/*
		 * Lambda表达式的代码块只有一条语句，可以省略花括号
		 * 不带形参的匿名方法
		 */
		lq.eat(() -> System.out.println("苹果的味道很好！！"));
		
		//参数列表可以省略参数类型，参数列表只有一个参数，可以省略圆括号
		lq.drive( weather -> {
			System.out.println("今天天气是："+weather);
			System.out.println("直升机飞行平稳！");
		});
		
		/*
		 * 重写的是实现类的方法，参数是形参，而不是实参
		 * 代码块只有一条语句，可以省略花括号，而且这句为返回语句，可以省略return关键字
		 */
		lq.test((a,b) -> a+b);
	}
}
