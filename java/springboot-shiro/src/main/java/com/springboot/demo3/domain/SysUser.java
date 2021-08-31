package com.springboot.demo3.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-18 11:03
 **/
@Data
public class SysUser implements Serializable {
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
}
