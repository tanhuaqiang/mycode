package com.dalingjia.test;

import com.daling.platform.util.Jackson2Helper;
import com.dalingjia.collection.myHashMap.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


/**
 * ObjectMapper readValue()方法
 * 利用泛型解决复杂json结构
 * @JsonIgnoreProperties(ignoreUnknown = true) 没有实例化的属性不自动赋值 没有这个回报异常
 *
 * @param <T>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageBean<T extends Object> {

    private pageinfo pageinfo;

    public PageBean.pageinfo getPageinfo() {
        return pageinfo;
    }

    public void setPageinfo(PageBean.pageinfo pageinfo) {
        this.pageinfo = pageinfo;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public class pageinfo{
        private int total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }




    private static String jsonString = "{\n" +
            "        \"messageList\": [\n" +
            "            {\n" +
            "                \"id\": \"7\",\n" +
            "                \"sendCompany\": \"广州机场\",\n" +
            "                \"recvCompany\": \"中国南航航空公司\",\n" +
            "                \"messageType\": \"1001\",\n" +
            "                \"sendTime\": \"2018-07-12 16:43:06\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"4\",\n" +
            "                \"sendCompany\": \"广州机场\",\n" +
            "                \"recvCompany\": \"中国南航航空公司\",\n" +
            "                \"messageType\": \"1002\",\n" +
            "                \"sendTime\": \"2018-07-12 15:49:02\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"pageinfo\": {\n" +
            "            \"pageNum\": 1,\n" +
            "            \"pageSize\": 3,\n" +
            "            \"size\": 2,\n" +
            "            \"startRow\": 1,\n" +
            "            \"endRow\": 2,\n" +
            "            \"total\": 2,\n" +
            "            \"pages\": 1,\n" +
            "            \"list\": null,\n" +
            "            \"prePage\": 0,\n" +
            "            \"nextPage\": 0,\n" +
            "            \"isFirstPage\": true,\n" +
            "            \"isLastPage\": true,\n" +
            "            \"hasPreviousPage\": false,\n" +
            "            \"hasNextPage\": false,\n" +
            "            \"navigatePages\": 8,\n" +
            "            \"navigatepageNums\": [\n" +
            "                1\n" +
            "            ],\n" +
            "            \"navigateFirstPage\": 1,\n" +
            "            \"navigateLastPage\": 1,\n" +
            "            \"firstPage\": 1,\n" +
            "            \"lastPage\": 1\n" +
            "        }\n" +
            "    }";

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {



//        ObjectMapper mapper = new ObjectMapper();
//        PageBean<MessageListVO> strPageBean = mapper.readValue(jsonString, PageBean.class);
//        System.out.println(strPageBean.getMessageList().get(0));
//        System.out.println(strPageBean.getMessageList().get(1));
//        System.out.println(strPageBean.getPageinfo().getTotal());
//        System.out.println(jsonString);
        java.util.Map<String, Object> map = Jackson2Helper.parsingObject(jsonString, new TypeReference<java.util.Map<String, Object>>() {
        });
        System.out.println(map);

        ObjectMapper mapper = new ObjectMapper();

        java.util.Map<String, Object> map2 = mapper.readValue(jsonString, new TypeReference<java.util.Map<String, Object>>() {});
        System.out.println(map2);
    }

}