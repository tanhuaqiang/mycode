package com.dalingjia.guava;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RateLimiterTest {

    // permitsPerSecond: 每秒允许的请求数
    // 每秒只能产生2个令牌
    private static final RateLimiter rateLimiter = RateLimiter.create(2);

    private static class UserRequest implements Runnable{

        private int id;

        public UserRequest(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("ID = " + id);
        }
    }

    public static void main(String[] args) {

        List<Runnable> tasks = new ArrayList<Runnable>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new UserRequest(i));
        }

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (Runnable runnable : tasks) {
            //阻塞队列，没有令牌时会阻塞
            /**
             * 第一次取是没有的，提前预取，导致循环第二次取时(很快)，由于被前一个线程取了，会阻塞等待0.5s用于弥补第一个线程取走的令牌，0.5s后又提前预取，
             * 导致第三个线程继续阻塞，就这样一直下去，所以后面的线程一直阻塞
             */
            System.out.println("等待时间：" + rateLimiter.acquire() + "s");//默认取一个需要的时间，当令牌桶为空时，可以提前取令牌
            threadPool.execute(runnable);
        }
    }

    @Test
    public void rateLimiter(){
        //Guava中开源出来一个令牌桶算法的工具类RateLimiter，可以轻松实现限流的工作
        /**
         * 可以看出，令牌桶每秒只能产生2个令牌，我们可以第一次取出5个，
         * 但是第二个再去取令牌的时候，需要等2.5s，也就是第一次令牌取完后，需要等2.5s才能取到令牌。2.5s用于弥补第一次取走的令牌
         * 同样的，第三次取1个令牌的时候，也需要等待第二次的1s的时间。也就是，取的速率可以超过令牌产生的速率，但是下一次再次去取的时候，需要阻塞等待。
         * 第二次取的等待时间是弥补第一次取的空缺时间
         * 第三次取的等待时间是弥补第二次取的空缺时间
         */
        System.out.println(rateLimiter.acquire(5));//取5个需要等待的时间, 每秒只能产生2个令牌, 5个就需要2.5秒
        System.out.println(miao());
        System.out.println(rateLimiter.acquire(2));
        System.out.println(miao());
        System.out.println(rateLimiter.acquire(1));

    }




    /**
     * tryAcquire(long timeout, TimeUnit unit)
     * 从RateLimiter 获取许可如果该许可可以在不超过timeout的时间内获取得到的话，则返回true
     * 或者如果无法在timeout 过期之前获取得到许可的话，那么立即返回false（无需等待）
     */
    public Object miao() {
        //判断能否在1秒内得到令牌，如果不能则立即返回false，不会阻塞程序
        //limiter.tryAcquire(): timeout为0，表示立刻获取令牌
//        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
//        if (!rateLimiter.tryAcquire()) {//能否立即取到
        if (!rateLimiter.tryAcquire(1)) {//能否立即获取一个令牌
            return "短期无法获取令牌，真不幸，排队也瞎排, 失败";
        }
        //更新操作
        return "成功";
    }
}
