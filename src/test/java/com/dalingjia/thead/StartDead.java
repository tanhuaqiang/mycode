package com.dalingjia.thead;

public class StartDead extends Thread{

	private int i ;
	public void run(){
		for ( ; i < 100 ; i++) {
			System.out.println(getName()+"\t"+ i);
		}
	}
	
	public static void main(String[] args) {
		StartDead sDead = new StartDead();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"\t"+i);
			if (i==20) {
				sDead.start();
				//测试线程是否处于活动状态
				System.out.println(sDead.isAlive());
			}
			//线程结束，线程死亡，想要再次启动线程就必须新建线程
			if (i>20 && !sDead.isAlive()) {
				sDead.start();
			}
		}
	}
}

