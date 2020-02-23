package com.dalingjia.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射：动态的加载一个类，动态的new一个对象，动态的调用对象的方法
 * @author Administrator
 *
 */
public class TestReflect {

	public static void main(String[] args) {
		/**
		 * 加载properties配置文件
		 * 配置文件必须建在src目录下
		 */
		InputStream in = ClassLoader.getSystemResourceAsStream("reflect.properties");
//		InputStream in = TestReflect.class.getClassLoader().getResourceAsStream("reflect.properties");
		/**
		 * 将配置文件信息保存到Properties对象中
		 */
//		Properties prop = new Properties();//自定义Properties对象
		Properties prop = System.getProperties();//获取系统的配置文件对象
		try {
			prop.load(in);
			//获取配置文件的信息
			String str = prop.getProperty("class");
			/**
			 * 将类名为str的类加载到内存中
			 * 加载类,类名必须是完全限定名：com.gcms.ref.User
			 * 获得Class对象
			 */ 
			Class<?> c = Class.forName(str);
			//获取Class对象的实例，即产生一个对象
			Object obj = c.newInstance();
			//获取类的方法
			Method[] methods = c.getMethods();
			for (Method method : methods) {
				if ("me".equals(method.getName())) {
					/**
					 * 参数介绍：该方法属于哪个对象obj
					 * 方法的调用用method.invoke即可
					 */
					method.invoke(obj);
				}
				if("mm".equals(method.getName())){
					//invoke方法的参数就是method方法的参数
					method.invoke(obj, 2, "4", 6);
					Class returnType = method.getReturnType();//获取方法的返回值类型
					System.out.println(returnType.getName());
					
					//获取方法的所有参数类型
					Class[] parameterType = method.getParameterTypes();
					for (Class parameter : parameterType) {
						System.out.println(parameter.getName());
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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


class User implements Cloneable{
	static{
		System.out.println("User load !");
	}
	public User(){
		System.out.println("User 构造方法");
	}
	private Integer age;
	private String name;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void me(){
		System.out.println("自定义方法！！！");
	}
	public void mm(int i, String j, Integer k){
		System.out.println("i+j+k=" + (i+j+k));
	}

	public Object clone() throws CloneNotSupportedException{
		System.out.println("--clone--");
		return super.clone();
	}
}