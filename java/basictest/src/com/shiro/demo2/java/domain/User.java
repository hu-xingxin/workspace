package com.shiro.demo2.java.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 09:40:28
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private String password;
    private String salt;

    public User(String userName){
        this.userName = userName;
    }

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public User(String userName,String password,String salt){
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }
}
