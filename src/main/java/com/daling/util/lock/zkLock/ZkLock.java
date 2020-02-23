package com.daling.util.lock.zkLock;

import java.io.Closeable;
import java.util.concurrent.TimeUnit;

public interface ZkLock extends Closeable {

    /**
     * 获取锁, 等待直到返回
     */
    void lock() throws Exception ;

    /**
     * 尝试获取锁, 立刻返回结果
     */
    boolean tryLock()throws Exception;

    /**
     * @param waitTime 等待时间
     * @param unit 时间单元, null为永久等待
     * @return
     * @throws Exception
     */
    boolean tryLock(long waitTime, TimeUnit unit) throws Exception;

    void unlock() throws Exception;

    @Override
    void close() ;
}
