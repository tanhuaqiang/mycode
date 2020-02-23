package com.dalingjia.thead;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {

	public static void main(String[] args) {
		/**
		 * 创建一个 FutureTask，一旦运行就执行给定的 Callable
		 * Callable是函数式接口，只有一个抽象方法call()，可以使用Lambda表达式创建Callable对象的实现类，再进行强转
		 * 使用FutureTask来包装Callable对象
		 * FutureTask实现了Runable接口，可以作为Thread的target
		 */
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {
			int i=0;
			for ( ; i < 100; i++) {
				System.out.println(Thread.currentThread().getName()+"循环变量i的值："+ i );
			}
			//call()方法可以有返回值,最终返回100
			return i;
		});
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"的循环变量i:"+ i );
			if (i==20) {
				new Thread(task, "有返回值的线程").start();
			}
		}
		
		try {
			//返回Callable任务里call()方法的返回值，调用该方法将导致主线程被阻塞，必须等到子线程结束后才会得到返回值
			System.out.println("子线程的返回值："+task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
