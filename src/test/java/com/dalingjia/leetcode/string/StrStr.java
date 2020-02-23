package com.dalingjia.leetcode.string;

import com.daling.bean.User;

import java.util.Objects;
import java.util.UUID;

public class StrStr {

    private static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack == null || haystack.equals("")) {
            return -1;
        }
        return haystack.indexOf(needle);
    }


    public static void main(String[] args) {
        String random = UUID.randomUUID().toString() + "-" + Thread.currentThread().getId();
        Long rand = Thread.currentThread().getId();
        System.out.println(random);
        System.out.println(rand);

        System.out.println("--------------------");
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getId());
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        User user = new User();
        Integer age = new Integer(0);
        user.setAge(Objects.isNull(random) ? age : user.getAge());
        System.out.println(user.getAge());

        Long a = null;
        boolean flag = false;
//        Long tt = new Long(0L);
        Long b = flag ? Long.valueOf(0L) :a;
        System.out.println(b);
    }
}
