package com.dalingjia.test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuavaTest {

    @Test
    public void testImmutable(){
        String[] strings = {"a", "b", "c"};
        System.out.println(strings.length);

        String string = "abcgdfd";
        System.out.println(string.length());

        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list："+list.size());

        ImmutableList<String> imlist=ImmutableList.copyOf(list);
        System.out.println("imlist："+imlist);

        ImmutableList<String> imOflist=ImmutableList.of("peida","jerry","harry");
        System.out.println("imOflist："+imOflist);

        ImmutableSortedSet<String> imSortList=ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
        System.out.println("imSortList："+imSortList);

        list.add("baby");
        System.out.println("list add a item after list:"+list);
        System.out.println("list add a item after imlist:"+imlist);


        ImmutableSet<Color> imColorSet = ImmutableSet.<Color>builder()
                        .add(new Color(0, 255, 255))
                        .add(new Color(0, 191, 255))
                        .build();

        System.out.println("imColorSet:"+imColorSet);
        System.out.println("================================================");
        ImmutableList<Integer> list2 = ImmutableList.of(43333);
        System.out.println("list2=" + list2);
    }

    @Test
    public void testCopyOf(){

        ImmutableSet<String> imSet=ImmutableSet.of("peida","jerry","harry","lisa");
        System.out.println("imSet："+imSet);

        ImmutableList<String> imlist=ImmutableList.copyOf(imSet);
        System.out.println("imlist："+imlist);

        ImmutableSortedSet<String> imSortSet=ImmutableSortedSet.copyOf(imSet);
        System.out.println("imSortSet："+imSortSet);

        List<String> list=new ArrayList<String>();
        for(int i=0;i<20;i++){
            list.add(i+"x");
        }
        System.out.println("list："+list);

        ImmutableList<String> imInfolist=ImmutableList.copyOf(list.subList(2, 18));
        System.out.println("imInfolist："+imInfolist);

        int imInfolistSize=imInfolist.size();
        System.out.println("imInfolistSize："+imInfolistSize);

        ImmutableSet<String> imInfoSet=ImmutableSet.copyOf(imInfolist.subList(2, imInfolistSize-3));
        System.out.println("imInfoSet："+imInfoSet);
    }

    @Test
    public void testImmutableMap(){
        ImmutableMap<Integer,  String> immutableMap = new ImmutableMap.Builder<Integer,  String>()
                .put(1,"aaa")
                .put(2,"aaa")
                .put(3,"aaa")
                .build();
        System.out.println(immutableMap);
    }
}
