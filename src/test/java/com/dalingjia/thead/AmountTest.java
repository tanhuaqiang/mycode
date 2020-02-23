package com.dalingjia.thead;

public class AmountTest extends Thread{

	//创建一个账户
	private static final Account ACCOUNT = new Account("100001",10000.00);
	
	public AmountTest(String name){
		super(name);
	}
	
	public void run(){
		ACCOUNT.draw(8000.00);
	}
	
	public static void main(String[] args) {
		new AmountTest("甲").start();
		new AmountTest("乙").start();
	}
}
