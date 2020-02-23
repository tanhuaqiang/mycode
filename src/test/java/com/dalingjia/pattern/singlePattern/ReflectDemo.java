package com.dalingjia.pattern.singlePattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {

	public static void main(String[] args) {
		//获取Class对象
		Class clazz = SingletonPattern.class;
		try {
			/**
			 * 返回带有指定参数列表的构造方法的 Constructor对象，此处是无参数的构造方法
			 */
			Constructor c0 = clazz.getDeclaredConstructor();
			/**
			 * 将此对象的 accessible 标志设置为指示的布尔值
			 * 将私有的构造方法设置为可用
			 * 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。
			 * 值为 false 则指示反射的对象应该实施 Java 语言访问检查
			 * 如果不设置为true,则会报：java.lang.IllegalAccessException:
			 */
			c0.setAccessible(true);
			SingletonPattern st = (SingletonPattern) c0.newInstance();
			
			/**
			 * 返回带有指定参数列表的构造方法的 Constructor对象，此处是有参数的构造方法
			 * 调用哪个构造方法，就传哪个参数
			 */
			Constructor c1 = clazz.getDeclaredConstructor(String.class);
			c1.setAccessible(true);
			SingletonPattern st2 = (SingletonPattern)c1.newInstance("tanhq");
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
