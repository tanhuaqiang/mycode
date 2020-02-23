package com.dalingjia.Enum;

import java.util.Arrays;

public enum Day {

    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");//记住要用分号结束

    private String desc;//中文描述

    /**
     * 私有构造,防止被外部调用
     * @param desc
     */
    private Day(String desc){
        this.desc=desc;
    }

    /**
     * 定义方法,返回描述,跟常规类的定义没区别
     * @return
     */
    public String getDesc(){
        return desc;
    }

    public static void main(String[] args){
        // values(): 此方法可以将枚举类转变为一个枚举类型的数组
        for (Day day:Day.values()) {
            //name(): 返回此枚举常量的名称
            System.out.println("name:"+day.name() + ",desc:"+day.getDesc());
        }

        Day[] ds=Day.values(); //此方法可以将枚举类转变为一个枚举类型的数组
        for (int i = 0; i < ds.length; i++) {
            System.out.println(ds[i].name() + ds[i].getDesc());
        }

        System.out.println("============================");

        //正常使用
        Day[] days = Day.values();
        //向上转型Enum
        Enum e = Day.MONDAY;
        //name(): 返回此枚举常量的名称
        System.out.println(e.name());
        //无法调用,没有此方法
        //e.values();
        //获取class对象引用
        Class<?> clazz = e.getDeclaringClass();
        if(clazz.isEnum()) {
            Day[] day = (Day[]) clazz.getEnumConstants();
            System.out.println("days:"+ Arrays.toString(day));
        }
    }

}
