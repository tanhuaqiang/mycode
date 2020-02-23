package com.dalingjia.annotation;

public class MyTest {

    @MyAnnotation(hello = "hello beijing", world = "hello world")
    public void output(){
        System.out.println("method output is running " );
    }

}
