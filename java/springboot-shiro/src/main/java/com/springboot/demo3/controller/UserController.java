package com.springboot.demo3.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.demo3.domain.SysUser;
import com.springboot.demo3.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 18:30:00
 * @Description
 */
@Api(tags = "分页测试和事务测试接口")
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 分页测试
     * @return
     */
    @GetMapping("userList")
    @ResponseBody
    @ApiOperation(value = "分页测试", consumes = "分页测试", notes = "分页测试")
    public List<SysUser> getUserList(){
        Page<Object> page= PageHelper.startPage(1, 5);
        return userService.queryUserList(null);
    }

    /**
     * 事务测试
     */
    @PostMapping("addUser")
    @Transactional
    @ApiOperation(value = "事务测试", consumes = "事务测试", notes = "事务测试")
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
