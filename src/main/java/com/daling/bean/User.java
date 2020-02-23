package com.daling.bean;

import lombok.Data;

import java.io.*;
import java.util.*;

@Data
public class User implements Serializable{

    private Integer id;
    private String  name;
    private Integer age;
    private Date date;
    private Integer grade;
    private String receiveAddress;

    private List<Orders> ordersList;

    public User() {
        System.out.println("无参数的构造方法");
    }

    public User(String name) {
        System.out.println("name:" + name);
    }

    public User(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public User(Integer id, String name, Integer grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //受保护的构造方法
    protected User(boolean flag){
        System.out.println("受保护的构造方法flag: " + flag);
    }

    //私有的构造方法
    private User(Integer age){
        System.out.println("私有的构造方法：age=" + age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }



    public static void main(String[] args) {
        InputStream in = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            in = User.class.getResourceAsStream("/info/BuFaMessage.txt");
            reader = new BufferedReader(new InputStreamReader(in));
            writer = new BufferedWriter(new FileWriter("userInfo.txt"));//该文件在项目的根目录下
            String str = null;
            String[] strings = null;
            while ((str = reader.readLine()) != null){
//                System.out.println(str);
                strings = str.split(",");
            }
            for (String s : strings){
                System.out.println(s.trim());
                writer.write(s.trim());
                writer.newLine();//换行
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**
             * 程序打开的文件IO资源不属于内存里的资源，垃圾回收机制无法回收改资源，所以应该显示关闭文件IO资源
             */
            if (reader != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
