package com.dalingjia.reflect.myReflect;

import com.daling.bean.Employee;

import java.lang.reflect.Method;

public class TestMethod {

    public static void main(String[] args) {
        Class clazz = null;
        try {
            clazz = Class.forName("com.daling.bean.Employee");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Employee employee = null;
        try {
            employee = (Employee)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }

        System.out.println("***************获取所有的方法，包括私有的*******************");
        methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method);
        }

        System.out.println("***************获取公有的show1()方法*******************");
        Method method = null;
        try {
            method = clazz.getMethod("show1", String.class);
            method.invoke(employee, "ok");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("***************获取私有的show4()方法******************");
        try {
            method = clazz.getDeclaredMethod("show4", String.class, Integer.class);
            method.setAccessible(true);
            method.invoke(employee, "tanhq", 25);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
