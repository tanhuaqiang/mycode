package com.dalingjia.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

class Test {

    public static String handlePhone(String phone) {
        if (StringUtils.isNotBlank(phone) && phone.length() == 11) {
            return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        }
        return phone;
    }

    public static void main(String[] args) {

        List<Long> longList = Lists.newArrayList(111L, 2L, 3L);
        List<Long> part = Lists.newArrayList(2L, 3L, 4L);
        System.out.println(longList.containsAll(part));
        System.out.println("jljflsf");

        System.out.println(handlePhone("18332444942"));
        System.out.println(handlePhone("1783232"));
    }



}

