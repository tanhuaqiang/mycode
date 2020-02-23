package com.dalingjia.thead;

public class SecondThread implements Runnable {

	private int i;
	
	@Override
	public void run() {

		for ( ; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"\t"+i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"\t"+i);
			if(i==2){
				SecondThread st = new SecondThread();
				new Thread(st, "新的线程1").start();
				new Thread(st, "新的线程2").start();
			}
		}
	}
}
