package com.mybatis.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-19 09:42
 **/
public class MybatisUtil {
    static SqlSessionFactory factory = null;
    static {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = MybatisUtil.class.getClass().getResourceAsStream("/mybatis.cfg.xml");
        factory = factoryBuilder.build(is);
    }

    public static SqlSession getSession(){
        return factory.openSession();
    }
}
