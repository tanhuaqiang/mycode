package com.dalingjia.thead.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		//创建一个具有固定线程数量（100个）的线程池
		ExecutorService pool1 = Executors.newCachedThreadPool();
		ExecutorService pool2 = Executors.newFixedThreadPool(100);
		ExecutorService pool3 = Executors.newSingleThreadExecutor();
		ExecutorService pool4 = Executors.newScheduledThreadPool(3);
		ExecutorService pool5 = Executors.newSingleThreadScheduledExecutor();
		ExecutorService pool6 = Executors.newWorkStealingPool();
		ExecutorService pool7 = Executors.newWorkStealingPool(3);

		//使用lambda表达式创建Runnable对象
		Runnable target = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName()+"的i值为："+i);
			}
		};
		//向线程池中提交2个线程，有空闲线程时，会自动执行
		pool2.submit(target);
		pool2.submit(target);
		//关闭线程池
		pool2.shutdown();
	}
}
