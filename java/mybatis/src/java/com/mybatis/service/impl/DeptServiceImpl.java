package com.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.domain.SysDept;
import com.mybatis.domain.SysUser;
import com.mybatis.mapper.DeptMapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.service.IUserService;
import com.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-18 11:39
 *  使用接口来调用方法
 **/
public class DeptServiceImpl{
    public SysDept queryUserById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        SysDept dept = mapper.queryDeptById(id);
        sqlSession.close();
        return dept;
    }

}
