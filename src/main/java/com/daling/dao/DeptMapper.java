package com.daling.dao;

import com.daling.bean.Dept;

import java.util.List;

public interface DeptMapper {

    /**
     * 添加部门
     */
    public void saveDept(Dept dept);

    /**
     * 删除部门
     */
    public void delDept(Integer did);

    /**
     * 修改部门
     */
    public void updateDept(Dept dept);

    /**
     * 查询某个部门
     */
    public Dept selDept(Integer did);

    /**
     * 查询所有的部门
     */
    public List<Dept> selAllDept();

    /**
     * 查询有多少个部门
     */
    public Long selectCount() ;
}
