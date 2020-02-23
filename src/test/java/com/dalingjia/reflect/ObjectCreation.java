package com.dalingjia.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectCreation {
	
	public static void main(String[] args) throws 
		InstantiationException, IllegalAccessException, 
		ClassNotFoundException, NoSuchMethodException, SecurityException, 
		IllegalArgumentException, InvocationTargetException, 
		FileNotFoundException, IOException {
		
		//1,new对象,调用构造方法
		Employee emp1 = new Employee();
		emp1.setName("tanhq");
		System.out.println(emp1+", hashCode = "+emp1.hashCode());
		
		//2，使用class对象的newInstance()方法,调用构造方法
//		Employee emp2 = Employee.class.newInstance();
		Employee emp2 = (Employee) Class.forName("com.gcms.ref.Employee").newInstance();
		emp2.setName("Rishi");   
        System.out.println(emp2 + ", hashcode = " + emp2.hashCode());  
        
        //3，使用Constructor对象的newInstance()方法
        Constructor<Employee> constructor = Employee.class.getConstructor();
        Employee emp3 = constructor.newInstance();
        emp3.setName("Yogesh");   
        System.out.println(emp3 + ", hashcode = " + emp3.hashCode());  
        
        /**
         * 4,调用对象的clone()方法，jvm会创建一个新对象，将前面对象的内容全部拷贝进去。
         *   使用clone()方法创建对象并不会调用任何构造函数
         */
        Employee emp4 = (Employee) emp3.clone();
        emp4.setName("laomao");
        System.out.println(emp4 + ", hashcode = " + emp3.hashCode());
        
        /**
         * 5,使用序列化和反序列化，jvm会给我们创建一个单独的对象，jvm不会调用任何构造函数
         * 序列化：把对象转换为 "字节序列" 的过程称为对象的序列化
		 * 反序列化：把 "字节序列" 恢复为对象的过程称为对象的反序列化
         */
        //使用对象输出流ObjectOutputStream 将emp4 输出到data.txt文件中
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:\\data.txt"));
        out.writeObject(emp4);
        out.close();
        
        //使用对象输入流ObjectInputStream将emp4写入
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("d:\\data.txt"));
        Employee emp5 = (Employee) input.readObject();
        input.close();
        emp5.setName("fangliang");
        System.out.println(emp5 + ",hashCode = " + emp5.hashCode());
	}
}
