package com.dalingjia.spring.service.impl;

import com.dalingjia.spring.service.IndexService;
import com.dalingjia.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/10/28 下午6:49
 * @Version 1.0
 **/
@Service
public class IndexServiceImpl implements IndexService {

    @Override
    public void indexService() {
        System.out.println("Constructor IndexService");
    }
}

//    public StudentService getStudentService() {
//        System.out.println("------------getStudentService----------");
//        return studentService;
//    }
    
    
    
    