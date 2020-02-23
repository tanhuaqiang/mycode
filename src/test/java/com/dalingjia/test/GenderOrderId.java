package com.dalingjia.test;

import org.joda.time.DateTime;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用Java实现一个订单号生成器
 */
public class GenderOrderId {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    private static String genderOrderId(String mobile) {
        String time = DateTime.now().toString("yyyyMMddHHmmss");
//        Long time = System.currentTimeMillis();
        int rand = new Random().nextInt(6);
        return time + "_" + mobile + "_" + atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {
        System.out.println(genderOrderId("18332559937"));
        System.out.println(genderOrderId("18332559937"));
        System.out.println(genderOrderId("18332559937"));
    }
}
