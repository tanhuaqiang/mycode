package com.dalingjia.threadpool;

public class MyTest extends Thread{

	private Account account;
	
	public MyTest(Account account , String name){
		super(name);
		this.account = account;
	}
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			if (i==6) {
				//getName()返回当前线程名称
				account.setName(getName());
			}
			//返回此线程局部变量中当前线程副本中的值
			System.out.println(account.getName()+"账户的i值："+i);
		}
	}
}
