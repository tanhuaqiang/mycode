package com.daling.enums;

import com.google.common.collect.Lists;

import java.util.List;

enum Season {

    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

    public static Season valueOf(int ordinal) {
        if (ordinal < 0 || ordinal >= values().length) {
            throw new IndexOutOfBoundsException("Invalid ordinal");
        }
        return values()[ordinal];
    }


    public static void main(String[] args) {
        System.out.println(valueOf(2));

        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(new Integer(2));
        System.out.println(list);
    }
}
