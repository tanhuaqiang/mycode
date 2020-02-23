package com.dalingjia.test;

class Person {

    public static void main(String[] args) {
        int i = 2;
        i = i++;
        System.out.println(i);//2

        int j = 2;
        j = ++j;
        System.out.println(j);//3
    }
}