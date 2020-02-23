package com.dalingjia.thead;

import java.util.Date;

public class SleepTest extends Thread{

	public SleepTest(String name){
		super(name);
	}
	
	public void run(){
		for (int i = 0; i < 50; i++) {
			System.out.println(this.getName()+"\t"+i);
		}
	}
	
	public static void main(String[] args) {
		SleepTest sleepTest = new SleepTest("线程睡眠");
		for (int i = 0; i < 5; i++) {
			System.out.println(new Date());
			if(i==2){
				sleepTest.start();
			}
			try {
				Thread.sleep(2000);//线程睡眠会释放资源cpu
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
