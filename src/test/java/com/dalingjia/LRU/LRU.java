package com.dalingjia.LRU;

import org.junit.Test;

import java.util.*;

/**
 * @author tanhq
 * @Description LRU算法java实现
 * <p>
 * LRU是Least Recently Used的缩写，即最近最少使用，常用于页面置换算法，是为虚拟页式存储管理服务的。
 * 即当一个数据最近一段时间没有被访问，未来被访问的概率也很小。当空间被占满后，最先淘汰最近最少使用的数据。
 * @Date 2019/10/24 下午10:53
 * @Version 1.0
 **/
public class LRU<K, V> {

    /**
     * LinkedHashMap负载因子默认0.75
     */
    private static final float hashLoadFactory = 0.75f;
    private LinkedHashMap<K, V> map;
    private int cacheSize;

    /**
     * 容量
     *
     * @param cacheSize
     */
    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int) Math.ceil(cacheSize / hashLoadFactory) + 1;
        /**
         * initialCapacity - 初始容量
         * loadFactor - 加载因子
         * accessOrder - 排序模式 - 对于访问顺序，为 true；对于插入顺序，则为 false
         */
        map = new LinkedHashMap<K, V>(capacity, hashLoadFactory, true) {
            /*
             * 当map容量大于LRU的容量时，删除最近最少使用的数据
             * 如果此映射移除其最旧的条目，则返回 true。
             * 在将新条目插入到映射后，put 和 putAll 将调用此方法。
             * 此方法可以提供在每次添加新条目时移除最旧条目的实现程序。
             * 如果映射表示缓存，则此方法非常有用：它允许映射通过删除旧条目来减少内存损耗。
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return map.size() > LRU.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedSize() {
        return map.size();
    }

    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(entry.getValue() + "--");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        LRU<String, Integer> lru = new LRU<>(3);
        for (int i = 0; i < 50; i++) {
            lru.put("aa" + i, i);
            lru.print();
        }
    }

}

 
    
    
    
    