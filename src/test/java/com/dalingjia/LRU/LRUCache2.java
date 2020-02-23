package com.dalingjia.LRU;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 */
public class LRUCache2 {

    private int capacity;

    private LinkedList<Integer> list = new LinkedList<Integer>();

    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));
            list.offerFirst(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));
        } else {
            if (capacity <= map.size()) {
                Integer lastKey = list.pollLast();
                map.remove(lastKey);
            }
        }
        list.offerFirst(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }

}