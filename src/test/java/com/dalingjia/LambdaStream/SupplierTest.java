package com.dalingjia.LambdaStream;

import java.util.function.Supplier;

class Student{
    private String name = "zhangsan";
    private int age = 25;

    //删掉这个会报错
    public Student() {

    }

    //加上这个也不报错
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class SupplierTest {

    public static void main(String[] args) {
        //创建Supplier容器，声明为String类型，此时并不会调用对象的构造方法，即不会创建对象
        Supplier<String> supplier = () -> "hello world";

        //调用get()方法，此时会调用对象的构造方法，即获得到真正对象
        //get方法不接受参数，返回一个结果
        System.out.println("supplier = [" + supplier.get() + "]");

        //替代不接受参数的工厂方法
        Supplier<Student> studentSupplier = () -> new Student();
        System.out.println(studentSupplier.get());

        //因为Student的构造方法不接受参数，返回一个结果，符合Supplier接口的要求，可以简写如下：
        //JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
        Supplier<Student> studentSupplier2 = Student::new;
        System.out.println(studentSupplier2.get());
    }
}

