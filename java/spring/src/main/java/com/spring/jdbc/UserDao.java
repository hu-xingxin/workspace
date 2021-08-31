package com.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-11 15:47
 **/
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer insertUser(SysUser user){
        String sql = "insert into sys_user(dept_id,login_name,user_name) values(?,?,?)";
        Object[] args = {user.getDeptId(),user.getLoginName(),user.getUserName()};
        return jdbcTemplate.update(sql,args);
    }
}
