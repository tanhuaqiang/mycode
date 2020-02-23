package com.dalingjia.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 每次生成动态代理对象时，都需要指定一个实现了InvocationHandler接口的调用处理器对象作为参数
 */
public class InvocationHandlerImpl implements InvocationHandler {

    //这个就是我们需要代理的真实对象，也就是真正执行业务逻辑的类
    private Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    /**
     * 该方法负责处理动态代理类上所有方法的调用
     *
     * @param proxy     最终生成的代理类实例
     * @param method    被调用的方法
     * @param args      调用上面方法时传入的参数
     * @return          method对应方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        startTransaction();
        //当代理对象调用真实对象的方法时，会自动跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object result = method.invoke(target, args);//代理对象和方法参数
        commitTransaction();
        return result;
    }

    private void startTransaction() {
        System.out.println("开启事物");
    }
    private void commitTransaction() {
        System.out.println("提交事物");
    }
}
