package com.dalingjia.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author tanhq
 * @Description 定义一个切面
 * @Date 2019/10/28 下午6:18
 * @Version 1.0
 **/
@Component
@Aspect
public class NotVeryUsefulAspect {


    /**
     * 声明切入点，满足execution中的方法调用之后，就会去进行切面操作，类似于触发了切面
     *             第一个*  代表返回任意类型
     *             第一个.. 代表所有的子包
     *             第一个*  代表方法名任意
     *             第二个.. 代表方法的参数是任意数量和类型
     */
    @Pointcut("execution(* com.dalingjia.spring..*(..))") // the pointcut expression
    private void anyOldTransfer() {

    }

    @Before("anyOldTransfer()")
    public void doAccessCheck() {
        System.out.println("-----------------aop----------------");
    }
}

 
    
    
    
    