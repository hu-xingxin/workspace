package com.shiro.demo4.java.utils;

import com.shiro.demo3.java.domain.User;
import com.shiro.demo3.java.service.UserService;
import com.shiro.demo3.java.service.impl.UserServiceImpl;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 17:09:46
 * @Description
 */
public class MD5Util {
    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        String password = "ls123456.";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        System.out.println(salt);
        int times = 2;
        String algorithmName = "md5";
        String encodePassword = new SimpleHash(algorithmName, password, salt, times).toString();
        System.out.println(encodePassword);

        User user = new User(null,"shiro",encodePassword,salt);
        Integer integer = userService.insertUser(user);
        System.out.println(integer);
    }
}
