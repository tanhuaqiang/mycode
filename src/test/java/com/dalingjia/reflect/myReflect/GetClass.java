package com.dalingjia.reflect.myReflect;

import com.daling.bean.User;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetClass {

    public static void main(String[] args) {

        //1,通过对象产生Class对象
        User user = new User();
        Class clazz = user.getClass();
        System.out.println(clazz.getName());

        //2,通过类名获取Class对象
        Class clazz2 = User.class;
        System.out.println(clazz == clazz2);//比较内存地址，获取的是同一个对象

        //3,通过类的完全限定名获取Class对象，最常用
        try {
            Class clazz3 = Class.forName("com.daling.bean.User");//参数必须是类的真实路径（包名+类名）
            System.out.println(clazz == clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getMessageFromTxt(){
        try {
            Class clazz = Class.forName(getValue("className"));
            Method method = clazz.getDeclaredMethod(getValue("methodName"));
            method.setAccessible(true);
            method.invoke(clazz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读取配置文件/Users/tanhq/gitLab/springboot/src/test/java/reflect.properties
    public String getValue(String key){
        Properties properties = new Properties();
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("info/pro.properties");
            properties.load(in);
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        //泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
        Class clazz = list.getClass();
        try {
            Method method = clazz.getMethod("add", Object.class);
            method.invoke(list, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Object object : list){
            System.out.println(object);
        }
    }
}
