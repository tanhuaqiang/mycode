package com.daling.dao.impl;

import com.daling.bean.Dept;
import com.daling.dao.DeptMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DeptMapperImpl extends SqlSessionDaoSupport implements DeptMapper {


    /**
     * @Resource: 这个注解和@Autowired注解是一个意思，都可以自动注入属性。由于SqlSessionFactory是MyBatis的核心，
     * 它在applicationContext.xml中又进行过了声明，因此这里通过@Resource注解将id为"sqlSessionFactory"的Bean给注入进来，
     * 之后就可以通过getSqlSession()方法获取到SqlSession并进行数据的增、删、改、查了。
     * @param sqlSessionFactory
     */
    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    /**
     * 整个过程中没有任何的commit、rollback，全部都是由Spring帮助我们实现的，这就是利用Spring对MyBatis进行事务管理。
     * @param dept
     */
    @Override
    public void saveDept(Dept dept) {
        //前一个是namespace，后一个是id
        int rows = getSqlSession().insert("dept.saveDept", dept);
        System.out.println("rows="+rows);
    }

    @Override
    public void delDept(Integer did) {

        int rows = getSqlSession().delete("dept.delDept", did);
        System.out.println("rows="+rows);
    }

    @Override
    public void updateDept(Dept dept) {

        int rows = getSqlSession().delete("dept.updateDept", dept);
        System.out.println("rows="+rows);
    }

    @Override
    public Dept selDept(Integer did) {

        Dept dept = getSqlSession().selectOne("dept.selDept", did);

        return dept;
    }

    @Override
    public List<Dept> selAllDept() {

        List<Dept> list = getSqlSession().selectList("dept.selAllDept");

        return list ;
    }

    @Override
    public Long selectCount() {

        Long count = getSqlSession().selectOne("dept.selectCount");

        return count ;
    }

}
