package com.dalingjia.LambdaStream;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/7/9.
 */
@Data
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private BigDecimal account;
    /**
     * 年级
     */
    private Integer grade;


    public User(Integer id, String name, Integer age, BigDecimal account, Integer grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.account = account;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
