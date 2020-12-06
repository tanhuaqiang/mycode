package com.dalingjia.test;

import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class MyTest {

    private static class Person {
        int idCard;
        String name;

        public Person(int idCard, String name) {
            this.idCard = idCard;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            //两个对象是否等值，通过idCard来确定
            return this.idCard == person.idCard;
        }

//        @Override
//        public int hashCode() {
//
//            return Objects.hash(idCard, name);
//        }
    }

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<Person, String>();
        Person person = new Person(1234, "乔峰");
        System.out.println(person.hashCode());
        Person person1 = new Person(1234, "萧峰");
        System.out.println(person1.hashCode());
        //put到hashmap中去
        map.put(person, "天龙八部");
        //get取出，从逻辑上讲应该能输出“天龙八部”
        System.out.println("结果:" + map.get(person));
        System.out.println("结果:" + map.get(person1));
        System.out.println(UUID.randomUUID().toString());

        List<Integer> list = Lists.newArrayList();
        System.out.println(list == null);
    }
}
