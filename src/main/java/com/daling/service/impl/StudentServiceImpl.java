package com.daling.service.impl;

import com.daling.bean.Dept;
import com.daling.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public void saveDept(Dept dept) {
        System.out.println("StudentServiceImpl");
    }
}
