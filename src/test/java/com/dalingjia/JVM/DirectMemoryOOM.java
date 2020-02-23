package com.dalingjia.JVM;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOOM {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        Field unsfaeField = Unsafe.class.getDeclaredFields()[0];
        unsfaeField.setAccessible(true);
        try {
            Unsafe unsafe = (Unsafe) unsfaeField.get(null);
            while (true){
                unsafe.allocateMemory(_1MB);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
