package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description 两个数组的交集
 * @Date 2019/8/21 下午6:49
 * @Version 1.0
 **/
public class Intersection {

    /**
     * 两个数组的交集   leetcode 349
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
            result[index++] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 2, 1};
        int[] s2 = {2, 2};
        intersection(s, s2);
    }

    /**
     * 两个数组的交集II   leetcode 350
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else {
                map.put(i, map.get(i) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0){
                    map.remove(i);
                }
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int i : list) {
            res[index++] = i;
        }
        return res;
    }

}

 
    
    
    
    