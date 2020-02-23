package com.daling.util;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于生成一个000-999的三位循环index 数字的工具类
 *
 * @author haitao.wang
 */
public class N000IdxLocalGener {
    static Logger log = LoggerFactory.getLogger(N000IdxLocalGener.class);

    private static int INDEX_MIN_VALUE = 0;
    private static int INDEX_MAX_VALUE = 9_9_9;

    private static AtomicInteger atomInt;

    private transient volatile long currms = System.currentTimeMillis();

    /**
     * 构造函数
     */
    private N000IdxLocalGener() {
        // (new Random()).nextInt(INDEX_MAX_VALUE);
        // atomInt = new AtomicInteger(0);
        atomInt = new AtomicInteger((new Random()).nextInt(INDEX_MAX_VALUE));

    }

    /**
     * 该类的一个对象，整个系统公用这一个对象。
     */
    private static class N000IndexGeneratorHolder {
        private static N000IdxLocalGener instance = new N000IdxLocalGener();
    }

    /**
     * 暂时不用。
     * <p>
     */
    public void finalize() {

    }

    /**
     * 获得这个类的一个对象。
     * <p>
     * 在任何时候，该类在系统中只有一个对象存在，整个系统公用该对象。
     *
     * @return 该类的一个对象。
     */
    public static N000IdxLocalGener getInstance() {
        return N000IndexGeneratorHolder.instance;
    }

    public synchronized int getNextIndexIntValue() {
        int rtnint = atomInt.getAndIncrement();
        if (atomInt.get() > INDEX_MAX_VALUE) {
            atomInt.set(INDEX_MIN_VALUE);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        return rtnint;
    }

    /**
     * 返回三位数字的字符串
     *
     * @return
     */
    public String getNextIndexString() {
        int intv = getNextIndexIntValue();
        if (intv < 10) {
            return "00" + String.valueOf(intv);
        } else if (intv < 100) {
            return "0" + String.valueOf(intv);
        } else {
            return String.valueOf(intv);
        }
    }

}
