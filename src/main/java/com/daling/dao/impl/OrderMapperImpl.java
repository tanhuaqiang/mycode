package com.daling.dao.impl;

import com.daling.bean.Dept;
import com.daling.bean.Orders;
import com.daling.dao.OrderMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/12/5 下午6:00
 * @Version 1.0
 **/
@Repository
public class OrderMapperImpl extends SqlSessionDaoSupport implements OrderMapper {


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


    @Override
    public List<Orders> loadOrdersUsers(Integer oid) {
        List<Orders> list = getSqlSession().selectList("orders.loadOrdersUsers", oid);

        return list ;
    }
}

 
    
    
    
    