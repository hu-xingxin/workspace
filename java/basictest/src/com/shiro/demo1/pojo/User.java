package com.shiro.demo1.pojo;

/**
 * @author huxingxin
 * @createTime 2021年08月15日 13:58:27
 * @Description 用户类，用于存放账号密码
 */
public class User {
    private String name;
    private String password;
    private String salt;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
