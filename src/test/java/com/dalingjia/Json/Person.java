package com.dalingjia.Json;

import lombok.Data;

@Data
public class Person {

    private Integer id;
    private String name;
    private Integer age;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
