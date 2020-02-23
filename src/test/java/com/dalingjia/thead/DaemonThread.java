package com.dalingjia.thead;

public class DaemonThread extends Thread{
	
	public DaemonThread(String name){
		super(name);
	}
	public void run(){
		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName()+"\t"+i);
		}
	}
	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread("守护线程");
		//将该线程设置为后台线程
		dt.setDaemon(true);
		dt.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"---------\t"+i);
		}
		//前台线程死亡后，jvm通知后台线程死亡需要一定的时间
	}
}
