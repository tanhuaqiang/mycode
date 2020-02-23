package com.daling.service;

import com.daling.bean.Dept;
import com.daling.platform.model.ResultVO;

import java.util.List;

public interface DeptService {

    /**
     * 添加部门
     */
    ResultVO<String> saveDept(Dept dept);

    /**
     * 删除部门
     */
    ResultVO delDept(Integer did);

    /**
     * 修改部门
     */
    ResultVO updateDept(Dept dept);

    /**
     * 查询某个部门
     */
    Dept selDept(Integer did);

    /**
     * 查询所有的部门
     */
    List<Dept> selAllDept();

    /**
     * 查询有多少个部门
     */
    Long selectCount();

}
