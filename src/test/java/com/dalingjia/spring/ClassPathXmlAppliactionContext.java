package com.dalingjia.spring;

import org.apache.ibatis.javassist.tools.reflect.Sample;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.BeansException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class ClassPathXmlAppliactionContext {
	
	private Map<Object,Object> beanMap = new HashMap<Object,Object>();
	
	public ClassPathXmlAppliactionContext(){
		SAXBuilder sb=new SAXBuilder();//解析xml的SAXBuiler对象
	    //构造文档对象 
	    Document doc = null;
		try {
			doc = sb.build(Sample.class.getClassLoader().getResourceAsStream("bean.xml"));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	    Element root=doc.getRootElement(); //获取根元素
	    List list=root.getChildren("bean");//取名字为bean的所有元素   
	    for(int i=0;i<list.size();i++){
	    	Element element=(Element)list.get(i);   
			String id=element.getAttributeValue("id"); //获取id  
			String clazz=element.getAttributeValue("class"); //获取class
			Object obj = null;
			try {
				//利用反射实例化对象
				obj = Class.forName(clazz).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			beanMap.put(id, obj);//将对象放入beanMap中
			
			for (Element propertyElement : (List<Element>)element.getChildren("property")) {
				String name = propertyElement.getAttributeValue("name");//userDao
				String ref = propertyElement.getAttributeValue("ref");//userDao
				Object refObject = beanMap.get(ref);//userDaoImpl
				//方法名 setUserDao
				String methodName = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);
				try {
					//获取方法，然后调用方法
					/* public class UserServiceImpl implements UserService
					 * refObject.getClass().getInterfaces()[0]:
					 * 返回的是UserDaoImpl类所实现的所有接口对象的一个数组，然后取第一个接口
					 * 获取的是UserService接口的Class对象
					 * 根据类中的方法名和方法的形参列表来获取方法
					 */
					Method method = obj.getClass().getMethod(methodName, refObject.getClass().getInterfaces()[0]);
					method.invoke(obj, refObject);//obj是方法所在的类对象，refObject是方法的形参列表(接口的实现类)
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	    }
	}

	public Object getBean(String obj) throws BeansException {
		return beanMap.get(obj);
	}
}
