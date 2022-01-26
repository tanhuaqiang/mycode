package com.dalingjia.util;

import com.google.common.collect.Lists;

import java.util.List;

class Test {


    public static void main(String[] args) {

        List<Long> longList = Lists.newArrayList(111L, 2L, 3L);
        List<Long> part = Lists.newArrayList(2L, 3L, 4L);
        System.out.println(longList.containsAll(part));
    }
}

