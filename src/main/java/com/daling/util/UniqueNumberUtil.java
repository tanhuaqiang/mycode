package com.daling.util;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : tanhq
 * @version : 唯一数工具类
 * @date : Created in 2019/12/20 下午8:31
 * @description:
 */
public class UniqueNumberUtil {

    private static final DecimalFormat df = new DecimalFormat("0000");
    private static final AtomicInteger atomic = new AtomicInteger(0);

    public static String getRandom() {

        //保证唯一性
        if (atomic.get() >= 10000) {
            atomic.set(0);
        }
        return System.currentTimeMillis() + df.format(atomic.getAndIncrement());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(getRandom());
                }
            });
            thread.start();
        }
    }
}
