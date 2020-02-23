package com.dalingjia.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;


/**
 * jdk动态代理必须实现InvocationHandler接口，通过反射代理方法，比较消耗系统性能，但可以减少代理类的数量，使用更灵活。
 */
public class JDKProxyTest {

    public static void main(String[] args) {

        //被代理的对象
        UserService userDao = new UserServiceImpl();
        //目标对象信息
        System.out.println("目标对象信息：" + userDao.getClass());
        /**
         * 生成一个InvocationHandler对象，需要传入被代理对象作为参数
         */
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userDao);

        Class<?> clazz = userDao.getClass();
        /**
         * JDK动态代理，有两个重要的类或接口：InvocationHandler, Proxy
         * 每个动态代理类都必须要实现InvocationHandler这个接口，并且每个代理类的实例都关联了一个handler
         * 当我们通过代理类对象调用这个方法时，这个方法的调用都会被转发为由InvocationHandler这个接口的invoke方法来调用
         *
         * 参数说明：
         * 1，指定当前目标对象使用的类加载器；
         * 2，一组目标对象实现的接口类型；
         * 3，调用处理器生成动态代理类实例（事件处理器）
         *
         * 我们给代理对象提供了一组什么接口，那么这个代理对象就是实现这组接口，当然也可以强制转换为这组接口中的任意一个
         *
         * Proxy.newProxyInstance创建的代理对象是在jvm运行时动态生成的一个对象，命名方式都是以$开头，最后一个数字表示对象的标号
         */
        //生成动态代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), invocationHandler);
        //代理对象信息
        System.out.println("代理对象信息：" + proxy.getClass());

        //当代理对象调用真实对象的方法时，会自动跳转到代理对象关联的handler对象的invoke方法来进行调用
        String result = proxy.hello("tanhq");
        System.out.println("返回值：" + result);
        //生成代理类的class文件
        createProxyClassFile();
    }

    /**
     * 生成代理类的class文件
     */
    public static void createProxyClassFile() {
        String name = "UserServiceProxy";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{UserService.class});
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("/Users/tanhq/test/" + name + ".class");
            out.write(data);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
