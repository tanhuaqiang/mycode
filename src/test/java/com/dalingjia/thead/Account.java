package com.dalingjia.thead;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

	//定义锁对象(可重入锁)，避免使用对象锁
	private final ReentrantLock lock = new ReentrantLock();
	
	private String accountNo;
	private Double balance;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public Account(String accountNo, Double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public Account() {
		super();
	}

	//提供一个线程安全的draw()方法来完成取钱操作
	public void draw(Double drawAmount){
		//加锁
		lock.lock();
		try {
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + "取钱成功，吐钞票：" + drawAmount);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("余额为：" + balance);
			} else {
				System.out.println("余额不足，取钱失败");
			}
			//修改完成后，释放锁
		} finally {
			lock.unlock();
		}
		
	}
	
}
