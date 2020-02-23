package com.dalingjia.bean;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class Student {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public int compareTo(Student o) {
//        //先比较name，name相同在比较age
//        if(this.name.compareTo(o.name) == 0){
//            if(this.age.compareTo(o.age) == 0){
//                return 0;
//            }else if (this.age > o.age){
//                return 1;
//            }else {
//                return -1;
//            }
//        }else if(this.name.compareTo(o.name) > 0){
//            return 1;
//        }else {
//            return -1;
//        }
//    }

    static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.name.compareTo(o2.name) == 0) {
                if (o1.age == o2.age) {
                    return 0;
                } else if (o1.age > o2.age) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (o1.name.compareTo(o2.name) > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        List list = new ArrayList<Student>();
        list.add(new Student("gol", 21));
        list.add(new Student("gol", 19));
//        list.add(new Student("xiao", 21));
//        list.add(new Student("long", 21));
        System.out.println("排序前：" + list);
        //排序规则：先按name排序，若name相等则再比较age
        Comparator comparator = new StudentComparator();
        Collections.sort(list, comparator);
        System.out.println("排序后：" + list);

        System.out.println(CollectionUtils.isNotEmpty(list));
    }
}
