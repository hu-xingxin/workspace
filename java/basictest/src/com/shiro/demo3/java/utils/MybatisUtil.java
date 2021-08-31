package com.shiro.demo3.java.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 10:34:16
 * @Description
 */
public class MybatisUtil {
    private static SqlSessionFactory factory;
    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream resource = MybatisUtil.class.getClass().getResourceAsStream("/com/shiro/demo3/resources/mybatis.cfg.xml");
        factory = builder.build(resource);
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = factory.openSession(true);
        return sqlSession;
    }

    public static <T> T getMapper(Class<T> type){
        return getSqlSession().getMapper(type);
    }
}
