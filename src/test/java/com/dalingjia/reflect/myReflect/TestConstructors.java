package com.dalingjia.reflect.myReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestConstructors {

    public static void main(String[] args) {
        Class clazz = null;
        try {
            clazz = Class.forName("com.daling.bean.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //1,获取所有公有的构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors){
            System.out.println(constructor);
        }

        //2,获取所有声明的构造方法
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            System.out.println(constructor);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        try {
            Constructor constructor = clazz.getConstructor(null);
            System.out.println(constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("******************获取私有构造方法，并调用*******************************");
        Integer age = 25;
        try {
            Constructor constructor = clazz.getDeclaredConstructor(age.getClass());
            //暴力访问
            constructor.setAccessible(true);
            //调用构造方法
            constructor.newInstance(age);
            System.out.println(constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
