package com.shiro.demo4.java.app;

import com.shiro.demo4.java.domain.User;
import com.shiro.demo4.java.service.UserService;
import com.shiro.demo4.java.service.impl.UserServiceImpl;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 17:34:05
 * @Description
 */
public class UserAction {
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
