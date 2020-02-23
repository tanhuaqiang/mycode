package com.dalingjia.Json;

import com.daling.platform.util.Jackson2Helper;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class ReadJson {

    public static void main(String[] args) {

        List<Long> longList = Lists.newArrayList();
        longList.add(1001L);
        longList.add(1002L);
        longList.add(1003L);
        System.out.println(Jackson2Helper.toJsonString(longList));
    }
}
