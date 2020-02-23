package com.daling.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Future;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/2/5 下午3:55
 * @description:
 */
public class FutureUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FutureUtil.class);

    private FutureUtil() {
    }

    public static <T> T get(Future<T> future) {
        return get(future, null);
    }

    public static <T> T get(Future<T> future, T defaultValue) {
        if (future == null) {
            LOGGER.warn("null future, use default value: {}", defaultValue);
            return defaultValue;
        } else {
            try {
                return future.get();
            } catch (Exception var3) {
                LOGGER.warn(var3.getMessage(), var3);
                return defaultValue;
            }
        }
    }

}
