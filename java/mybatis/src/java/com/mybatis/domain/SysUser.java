package com.mybatis.domain;

import com.github.pagehelper.Page;

import java.util.Arrays;
import java.util.Date;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-18 11:03
 **/
public class SysUser extends PageBean {
    private static final long serialVersionUID = 1L;

    //执法证号
    private String lawNum;

    //证件照地址
    private String lawFa;

    //用户ID
    private Long userId;

    //部门ID
    private Long deptId;

    //部门父ID
    private Long parentId;

    //角色ID
    private Long roleId;

    //登录名称
    private String loginName;

    //用户名称
    private String userName;

    //用户类型
    private String userType;

    //用户邮箱
    private String email;

    //手机号码
    private String phonenumber;

    //用户性别 "0=男,1=女,2=未知"
    private String sex;

    //用户头像
    private String avatar;

    //密码
    private String password;

    //盐加密
    private String salt;

    //帐号状态（0正常 1停用）
    private String status;

    //删除标志（0代表存在 2代表删除）
    private String delFlag;

    //最后登陆IP
    private String loginIp;

    //最后登陆时间
    private Date loginDate;

    //审批流程节点定义时，人员是否选中
    private boolean flag;

    //角色组
    private Long[] roleIds;

    //岗位组
    private Long[] postIds;

    //用户类型 0 系统用户 1 业户业户
    private String userGenre;

    //台账图标
    private String ledgerIcon;

    //登录权限
    private String loginPermission;

    private SysDept dept;

    public SysUser() {

    }

    public String getLawNum() {
        return lawNum;
    }

    public void setLawNum(String lawNum) {
        this.lawNum = lawNum;
    }

    public String getLawFa() {
        return lawFa;
    }

    public void setLawFa(String lawFa) {
        this.lawFa = lawFa;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds() {
        return postIds;
    }

    public void setPostIds(Long[] postIds) {
        this.postIds = postIds;
    }

    public String getUserGenre() {
        return userGenre;
    }

    public void setUserGenre(String userGenre) {
        this.userGenre = userGenre;
    }

    public String getLedgerIcon() {
        return ledgerIcon;
    }

    public void setLedgerIcon(String ledgerIcon) {
        this.ledgerIcon = ledgerIcon;
    }

    public String getLoginPermission() {
        return loginPermission;
    }

    public void setLoginPermission(String loginPermission) {
        this.loginPermission = loginPermission;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "lawNum='" + lawNum + '\'' +
                ", lawFa='" + lawFa + '\'' +
                ", userId=" + userId +
                ", deptId=" + deptId +
                ", parentId=" + parentId +
                ", roleId=" + roleId +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginDate=" + loginDate +
                ", flag=" + flag +
                ", roleIds=" + Arrays.toString(roleIds) +
                ", postIds=" + Arrays.toString(postIds) +
                ", userGenre='" + userGenre + '\'' +
                ", ledgerIcon='" + ledgerIcon + '\'' +
                ", loginPermission='" + loginPermission + '\'' +
                ", \ndept=" + dept +
                '}';
    }
}
