package com.dalingjia.LambdaStream;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.json.JSONObject;

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
                ", account=" + account +
                ", grade=" + grade +
                '}';
    }

    public static void main(String[] args) {
        BigDecimal account = new BigDecimal(32);
        User user = new User(1, "tanhq", 24, account, 23);

        System.out.println(user);
        System.out.println(JSON.toJSONString(user));
    }
}
