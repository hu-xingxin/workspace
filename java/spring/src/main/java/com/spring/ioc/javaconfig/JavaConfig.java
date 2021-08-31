package com.spring.ioc.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-10 14:09
 **/
@Configuration
public class JavaConfig {
    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

    @Bean
    public UserService userService(){
        return new UserService();
    }
}
