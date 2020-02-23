package com.daling.bean;

public class Employee {

    public String name;
    protected Integer age;
    char sex;
    private String tel;

    public Employee() {
    }

    //**************成员方法***************//
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(String name, Integer age){
        System.out.println("调用了，私有的，并且有返回值的，name = " + name + " , age = " + age);
        return "abcd";
    }

    private void show(){
        System.out.println("is show()");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("main方法执行了！！！！");
    }
}
