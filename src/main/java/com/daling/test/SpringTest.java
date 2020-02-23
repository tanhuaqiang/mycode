package com.daling.test;

import com.daling.annotation.AppConfig;
import com.daling.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/10/25 下午1:36
 * @Version 1.0
 **/
public class SpringTest {

    public static void main(String[] args) {
        //初始化spring容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentServiceImpl studentService = ac.getBean(StudentServiceImpl.class);
        studentService.saveDept(null);
    }
}

 
    
    
    
    