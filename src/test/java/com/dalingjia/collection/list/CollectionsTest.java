package com.dalingjia.collection.list;

import com.daling.util.common.CommonConstant;
import org.assertj.core.util.Lists;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/2/25 下午4:35
 * @description:
 */
public class CollectionsTest {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.add(4);
        list.add(3);
        list.add(9);
        list.add(24);
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        Map<String, Integer> map = new HashMap<>(2);
        System.out.println(map.get(CommonConstant.INTENTION));

        System.out.println(Collections.emptyMap().get(CommonConstant.INTENTION));
    }
}
