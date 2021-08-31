package com.servlet.utils;

import com.servlet.domain.User;
import com.servlet.service.UserService;
import com.servlet.service.impl.UserServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

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
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis.cfg.xml");
        factory = builder.build(resource);
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = factory.openSession(true);
        return sqlSession;
    }

    public static <T> T getMapper(Class<T> type){
        return getSqlSession().getMapper(type);
    }

    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        String password = "ls123456.";//密码
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        System.out.println(salt);
        int times = 2;//加密次数
        String algorithmName = "md5";//加密方式
        //加密后的面膜
        String passwordEncoded = new SimpleHash(algorithmName, password, salt, times).toString();
        System.out.println(passwordEncoded);

        User user = new User("shiro",passwordEncoded,salt);
        Integer integer = userService.insertUser(user);//创建用户
        System.out.println(integer);
    }
}
