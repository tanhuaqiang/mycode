package com.dalingjia.thead;

public class ConcurrencyTest {
    private static final Long count = 10000L;
    public static void main(String[] args) {

        concurrency();
        serial();
    }

    private static void concurrency(){
        long start = System.currentTimeMillis();
//        List<Integer> list = Lists.newArrayList();
//        Map<String,Integer> map = Maps.newConcurrentMap();
//        map.put("a", 0);

        //线程有创建和上下文切换的开销
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i =0 ;i< count;i++){
                a += 5;
            }
        });
        thread.start();

        int b = 0;
        for (long i = 0; i<count ; i++){
            b++;
        }

        try {
            /**
             * main线程调用了thread线程的join()方法，
             * main线程必须等thread线程执行结束后才会向下执行
             */
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency: " + time +"ms" );
        System.out.println(b);
        System.out.println(System.currentTimeMillis());
    }

    //串行执行不会有创建和上下文切换的开销，所以速度快
    private static void serial(){
        System.out.println(System.currentTimeMillis());
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i<count ;i++){
            a += 5;
        }
        int b = 0;
        for (long i= 0;i<count ;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time +"ms" );
    }


}
