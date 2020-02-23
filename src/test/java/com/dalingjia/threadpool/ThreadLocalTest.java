package com.dalingjia.threadpool;

public class ThreadLocalTest {

	public static void main(String[] args) {
		//2个线程共享一个Account
		Account account = new Account("初始名");
		new MyTest(account, "线程甲").start();
		new MyTest(account, "线程乙").start();

		Math.pow(3.3, 8);
	}
}
