package com.daling.test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.junit.Test;


public class TestAA {

    public void createUser(String name, Integer age, Integer version) {
    }

    public static void main(String[] args) throws Exception {
        for (Method m : TestAA.class.getMethods()) {
            if (m.getName().equals("main") || "createUser".equals(m.getName())) {
                System.out.println("--------------------");
                System.out.println(" method: " + m.getName());
                System.out.println(" return: " + m.getReturnType().getName());
                for (Parameter p : m.getParameters()) {
                    System.out.println("parameter:" + p.getType().getName() + ", " + p.getName());
                }
            }
        }
    }


    @Test
    public void test() {
        byte[] bytes = new byte[0];
        byte[] bytes2 = new byte[1];
        System.out.println(bytes.length);
        System.out.println(bytes2.length);
    }
}
