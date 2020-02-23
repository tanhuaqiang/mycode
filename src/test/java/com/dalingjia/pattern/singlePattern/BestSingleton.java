package com.dalingjia.pattern.singlePattern;

/**
 * 静态内部类的方式:
 * 		线程安全,并且不会提前初始化(对象只会在内部类加载的时候初始化，内部类只会在调用getInstance()方法的时候加载)
 * 		利用classLoader机制来保证初始化instance时只有一个线程，所以时线程安全的
 */
public class BestSingleton {

	private static class LazyHolder{
		private static final BestSingleton instance = new BestSingleton();
	}
	
	private BestSingleton(){}

	public static final BestSingleton getInstance(){
		return LazyHolder.instance;
	}
}
