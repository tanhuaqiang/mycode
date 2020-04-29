package com.daling.util;

import com.daling.util.common.CommonConstant;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/4/29 下午8:56
 * @description:
 */
public class ThreadPoolUtil {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();


    public static ExecutorService executorService = new ThreadPoolExecutor(
            CommonConstant.EXCEL_CORE_POOL_SIZE,
            CommonConstant.EXCEL_MAX_POOL_SIZE,
            CommonConstant.EXCEL_KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(CommonConstant.EXCEL_QUEUE_SIZE),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy()
    );

}
