package com.springboot.demo3.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.demo3.domain.SysUser;
import com.springboot.demo3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 18:30:00
 * @Description
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 分页测试
     * @return
     */
    @RequestMapping("userList")
    @ResponseBody
    public List<SysUser> getUserList(){
        Page<Object> page= PageHelper.startPage(1, 5);
        return userService.queryUserList(null);
    }

    /**
     * 事务测试
     */
    @RequestMapping("addUser")
    @Transactional
    public void addUser(){
        SysUser sysUserOne = new SysUser();
        sysUserOne.setLoginName("login_name1");
        userService.insertUser(sysUserOne);
        int i = 1 / 0;
        SysUser sysUserTwo = new SysUser();
        sysUserTwo.setLoginName("login_name2");
        userService.insertUser(sysUserTwo);
    }

}
