package com.dalingjia.thead.letterPrint;
 
/**
 * 多线程交替打印 1 - 100
 * @author Logan
 *
 */
public class ThreadPrintTest {
	// 创建变量
	int i = 1;
	
	public static void main(String[] args) {
		// 创建该类的对象
		ThreadPrintTest obj = new ThreadPrintTest();
		// 使用匿名内部类的形式，创建runnable对象
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while(obj.i <= 100){
					// 上锁当前对象
					synchronized(this) {
						// 唤醒另一个线程
						notify();
						System.out.println(Thread.currentThread().getName()  + "---"+ obj.i++);
						try {
							// wait会释放掉锁,进入阻塞状态
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}	
			}
		};
		// 启动多个线程（想创建几个就创建几个）
		new Thread(runnable).start();
		new Thread(runnable).start();

	}
}