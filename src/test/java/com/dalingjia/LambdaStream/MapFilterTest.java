package com.dalingjia.LambdaStream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFilterTest {

    public static void main(String[] args) {
        Map<Integer, List<Student>> map = Maps.newHashMap();
        List<Student> students1 = Lists.newArrayList();
        students1.add(new Student("tanhq", 10));
        students1.add(new Student("hhh", 20));
        students1.add(new Student("tt", 30));
        map.put(1, students1);

        List<Student> students2 = Lists.newArrayList();
        students2.add(new Student("xx", 10));
        students2.add(new Student("re", 20));
        students2.add(new Student("vj", 30));
        map.put(2, students2);

        System.out.println(map);

        map = map.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        (e) -> e.getValue().stream().filter(student -> student.getAge() == 30).collect(Collectors.toList())
                ));
        System.out.println(map);


        students1.forEach(student -> student.setAge(1));
        System.out.println(students1);

        Map<Integer, Student> studentHashMap = Maps.newHashMap();
        studentHashMap.put(1, new Student("thq", 20));
        studentHashMap.put(2, new Student("there", 24));
        studentHashMap.put(3, new Student("rick", 30));
        List<Student> values = Lists.newArrayList(studentHashMap.values());
        System.out.println(values);

    }
}
