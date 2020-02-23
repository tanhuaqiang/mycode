package com.dalingjia.reflect.myReflect;

import com.daling.bean.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestFields {

    public static void main(String[] args) {
        Class clazz = null;
        try {
            clazz = Class.forName("com.daling.bean.Employee");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("************获取所有公有的字段********************");
        Field[] fields = clazz.getFields();
        for(Field field : fields){
            System.out.println(field);
        }

        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field);
        }

        System.out.println("*************获取公有字段**并调用***********************************");
        Field field = null;
        try {
            field = clazz.getField("name");
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //获取一个对象
        Employee employee = null;
        try {
            employee = (Employee)clazz.newInstance();
            field.set(employee, "tanhq");
            System.out.println("姓名：" + employee.name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("**************获取私有字段****并调用********************************");
        try {
            field = clazz.getDeclaredField("tel");
            field.setAccessible(true);//暴力反射，解除私有限定
            field.set(employee, "18332559937");
            System.out.println("电话：" + employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
