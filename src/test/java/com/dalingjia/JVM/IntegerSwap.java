package com.dalingjia.JVM;

import java.lang.reflect.Field;

public class IntegerSwap {

    public static void main(String[] args) {
        Integer a = 1, b = 8;
        System.out.println("before: a=" + a + ",b=" + b);
        swap(a, b);
        System.out.println("after: a=" + a + ",b=" + b);
    }

    /**
     * java中方法的参数传递机制：
     * https://www.cnblogs.com/lixiaolun/p/4311863.html
     * @param x
     * @param y
     */
    private static void swap(Integer x, Integer y) {
        try {
            /**
             * -128~127 之间的值是从IntegerCache缓存中取得
             * public static Integer valueOf(int i) {
             *         if (i >= IntegerCache.low && i <= IntegerCache.high)
             *             return IntegerCache.cache[i + (-IntegerCache.low)];
             *         return new Integer(i);
             * }
             * private final int value;
             * 通过反射去修改private final变量
             *
             */
            Field field = Integer.class.getDeclaredField("value");
            //私有的成员属性是不能通过反射来赋值的
            field.setAccessible(true);
//            int temp = x.intValue();
            Integer temp = new Integer(x);
            // Integer a = 100; // 这是自动装箱  (编译器调用的是static Integer valueOf(int i))
            field.set(x, y.intValue());                 //x的值发生了改变
            //temp是int类型，需要自动装箱成Integer，会调用 static Integer valueOf(int i) 方法
            //直接修改了IntegerCache缓存数组中的值
            field.set(y, temp);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
