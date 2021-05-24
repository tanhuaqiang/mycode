package com.dalingjia.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MyTest {

    private static class Person {
        int idCard;
        String name;

        public Person(int idCard, String name) {
            this.idCard = idCard;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            //两个对象是否等值，通过idCard来确定
            return this.idCard == person.idCard;
        }

//        @Override
//        public int hashCode() {
//
//            return Objects.hash(idCard, name);
//        }
    }

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<Person, String>();
        Person person = new Person(1234, "乔峰");
        System.out.println(person.hashCode());
        Person person1 = new Person(1234, "萧峰");
        System.out.println(person1.hashCode());
        //put到hashmap中去
        map.put(person, "天龙八部");
        //get取出，从逻辑上讲应该能输出“天龙八部”
        System.out.println("结果:" + map.get(person));
        System.out.println("结果:" + map.get(person1));
        System.out.println("jjjj");

        MerchantExtensionDto dto = new MerchantExtensionDto();
        List<MerchantExtensionBo> list = Lists.newArrayList();
        MerchantExtensionBo bo = new MerchantExtensionBo();
        bo.setTenantId(113232L);
        bo.setPoiId(8323232L);
        bo.setDateKey(20210513);
        bo.setChannel(1);
        bo.setSpuId(2323L);
        bo.setSpuName("xxxxx");
        bo.setUvCnt(2323);
        MerchantExtensionBo bo1 = new MerchantExtensionBo();
        bo1.setTenantId(113232L);
        bo1.setPoiId(8323232L);
        bo1.setDateKey(20210513);
        bo1.setChannel(1);
        bo1.setSpuId(2323L);
        bo1.setSpuName("xxxxx");
        bo1.setUvCnt(2323);
        list.add(bo);
        list.add(bo1);
        dto.setMerchantExtensionBoList(list);
        dto.setTotal(18888L);
        System.out.println(JSON.toJSON(dto));
    }


}
