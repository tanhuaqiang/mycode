package com.dalingjia.myThreadPool;

public interface Future<T> {

    /**
     * 获取
     * @return 结果
     * @throws InterruptedException
     */
    T get() throws InterruptedException;
}