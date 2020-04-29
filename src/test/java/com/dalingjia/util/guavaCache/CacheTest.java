package com.dalingjia.util.guavaCache;

import com.google.common.cache.*;
import com.dalingjia.equals.Student;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {

    public static void main(String[] args) {

        //缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        LoadingCache<Integer, Student> studentCache =
                //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
                CacheBuilder.newBuilder()
                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                //设置写缓存后8秒钟过期
                .expireAfterWrite(8,TimeUnit.SECONDS)
                //设置缓存容器的初始容量为10
                .initialCapacity(10)
                 //设置缓存最大容量为100，超过100之后就会按照LRU最近最少使用算法来移除缓存项
                .maximumSize(100)
                 //设置要统计缓存的命中率
                .recordStats()
                 //设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
                        System.out.println(removalNotification.getKey() + " was removed , cause is " + removalNotification.getCause());
                    }
                })
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存（将对象保存到缓存中）
                .build(new CacheLoader<Integer, Student>() {
                    @Override
                    public Student load(Integer key) throws Exception {
                        System.out.println("load student " + key);
                        Student student = new Student();
                        student.setId(key);
                        student.setName("name " + key);
                        return student;
                    }
                });


        Student student = null;
        for (int i=0;i<20;i++) {
            //从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
            try {
                //从缓存中获取student对象; 没有的话先存储在缓存中，然后从缓存中获取
                student = studentCache.get(i);
                System.out.println(student);
                //休眠1秒
                TimeUnit.SECONDS.sleep(1);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("cache stats:");
        //最后打印缓存的命中率等 情况
        System.out.println(studentCache.stats().toString());
    }


    @Test
    public void sleepTest() {
        System.out.println("start = " + System.currentTimeMillis());
        //等待3000毫秒（3秒）
        Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
        System.out.println("end = " + System.currentTimeMillis());
    }
}
