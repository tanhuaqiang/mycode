package com.dalingjia.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyReflection {

    public static void main(String[] args) {
        //获得要调用的类
        Class<MyTest> myTargetTestClass = MyTest.class;
        try {
            //获得要调用的方法，output是要调用的方法的名字，new Class[]{}是参数
            Method method =  myTargetTestClass.getMethod("output", new Class[]{});
            //是否有类型为MyAnnotation的注解
            if(method.isAnnotationPresent(MyAnnotation.class)){
                //获的注解
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                //调用注解内容
                System.out.println(annotation.hello());
                System.out.println(annotation.world());
            }

            //获取所有注解，必须是Runtime类型的
            Annotation[] annotations = method.getAnnotations();
            Arrays.asList(annotations).forEach(
                //遍历所有注解的名字
                annotation -> System.out.println(annotation.annotationType().getName())
            );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
