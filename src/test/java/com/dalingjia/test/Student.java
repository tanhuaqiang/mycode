package com.dalingjia.test;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/12/3 下午9:05
 * @Version 1.0
 **/
public class Student implements Cloneable {
    private int age ;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Student() {}

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }

    /**
     * 所以，clone方法执行的是浅拷贝， 在编写程序时要注意这个细节
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student(26, "tanhq");
        Student student1 = (Student) student.clone();
        System.out.println(student.getName() == student1.getName());
        String result = student.getName() == student1.getName() ? "clone是浅拷贝的" : "clone是深拷贝的";
        System.out.println(result);
    }
}
