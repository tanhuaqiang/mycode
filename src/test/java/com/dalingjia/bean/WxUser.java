package com.dalingjia.bean;

public class WxUser {

    private Integer id;
    private String name;
    private Integer age = 25;
    private boolean isHZ ;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isHZ() {
        return isHZ;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHZ(boolean HZ) {
        isHZ = HZ;
    }

    public WxUser(Integer id, String name, Integer age, boolean isHZ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isHZ = isHZ;
    }

    public WxUser() {
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isHZ=" + isHZ +
                '}';
    }

    public static void main(String[] args) {
        System.out.println((0 -300)/200 + 1);
        System.out.println((22 -300)/200 + 1);
        System.out.println((100 -300)/200 + 1);
        System.out.println((133 -300)/200 + 1);
        System.out.println((200 -300)/200 + 1);
        System.out.println((233 -300)/200 + 1);
        System.out.println((300 -300)/200 + 1);
        System.out.println((430 -300)/200 + 1);
    }
}
