package com.dalingjia.spring.cyclicDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Z implements ApplicationContextAware {
	@Autowired
	X x;//注入X

    //构造方法
	public Z(){
		System.out.println("Z create ************************* ");
	}

    //生命周期初始化回调方法
	@PostConstruct
	public void zinit(){
		System.out.println("call z lifecycle init callback ************************* ");
	}

	//ApplicationContextAware 回调方法
	@Override
	public void setApplicationContext(ApplicationContext ac) {
		System.out.println("call aware callback ************************* ");
	}
}


