package com.springboot.demo1;

import com.springboot.demo3.domain.SysUser;
import com.springboot.demo3.mapper.UserMapper;
import com.springboot.demo3.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {
        Long count = jdbcTemplate.queryForObject("select count(*) from sys_user", Long.class);
        System.out.println(count);
    }

    /**
     * Junit单元测试时，在测试方法中打事务注解@Transactional
     * 默认会按照@Rollback(true)来进行处理，即使在没加注解@Rollback，也会对事务回滚
     * 解决办法
     * 1.@Rollback(value = false)
     * 2.@Commit
     * 添加之后 出现异常 也不会回滚
     */
    @Test
    @Transactional
    void addUser(){
        SysUser sysUserOne = new SysUser();
        sysUserOne.setLoginName("login_name1");
        userService.insertUser(sysUserOne);
        int i = 1 / 0;
        SysUser sysUserTwo = new SysUser();
        sysUserTwo.setLoginName("login_name2");
        userService.insertUser(sysUserTwo);
    }

}
