package com.daling.util.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Author : tanhq
 * @Date: 2018/12/17
 */
public class SqlSessionUtil {

    public static SqlSession getSqlSession(){
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

//        SqlSessionFactory ssf = ssfb.build(SqlSessionUtil.class.getClassLoader().getResourceAsStream("config/SqlMapperConfig.xml"));
        SqlSessionFactory ssf = ssfb.build(SqlSessionUtil.class.getClassLoader().getResourceAsStream("applicationContext.xml"));

        SqlSession sqlSession = ssf.openSession();
        return sqlSession;
    }
}
