package com.spring.hibernate.pojo;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 22:39
 **/
public class SysUser {
    private Integer userId;
    private Integer deptId;
    private String loginName;
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", deptId=" + deptId +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
