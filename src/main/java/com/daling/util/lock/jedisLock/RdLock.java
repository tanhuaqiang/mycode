package com.daling.util.lock.jedisLock;

import java.io.Closeable;
import java.util.concurrent.TimeUnit;

public interface RdLock extends Closeable {

    boolean tryLock();

    boolean tryLock(long var1, TimeUnit var3);

    void unlock();

    boolean isLocked();

    boolean isHoldByCurrentThread();

    @Override
    void close();


}
