package com.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.domain.SysUser;
import com.mybatis.service.IUserService;
import com.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-18 11:39
 * 使用SqlSession通过命名空间和方法id组成的字符串调用相应的方法
 **/
public class UserServiceImpl implements IUserService {
    @Override
    public SysUser queryUserById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSession();
        SysUser user = sqlSession.selectOne("com.mybatis.mapper.UserMapper.queryUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        SqlSession sqlSession = MybatisUtil.getSession();
        Page<Object> pageHelper = PageHelper.startPage(user.getCurrentPage(), user.getPageSize());
        List<SysUser> userList = sqlSession.selectList("com.mybatis.mapper.UserMapper.queryUserList", user);
        user.setTotalCount((int)pageHelper.getTotal());
        sqlSession.close();
        return userList;
    }

    @Override
    public List<SysUser> queryUserByListIds(List<SysUser> userList) {
        SqlSession sqlSession = MybatisUtil.getSession();
        userList = sqlSession.selectList("com.mybatis.mapper.UserMapper.queryUserByListIds", userList);
        sqlSession.close();
        return userList;
    }

    @Override
    public List<SysUser> queryUserByArrayIds(Long[] ids) {
        SqlSession sqlSession = MybatisUtil.getSession();
        List<SysUser> userList = sqlSession.selectList("com.mybatis.mapper.UserMapper.queryUserByArrayIds", ids);
        sqlSession.close();
        return userList;
    }

    @Override
    public List<SysUser> queryUserByMapIds(Map idMap) {
        SqlSession sqlSession = MybatisUtil.getSession();
        List<SysUser> userList = sqlSession.selectList("com.mybatis.mapper.UserMapper.queryUserByMapIds", idMap);
        sqlSession.close();
        return userList;
    }

    @Override
    public int insertUser(SysUser user) {
        SqlSession sqlSession = MybatisUtil.getSession();
        int insert = sqlSession.insert("com.mybatis.mapper.UserMapper.insertUser", user);
        sqlSession.close();
        return insert;
    }

    @Override
    public int updateUser(SysUser user) {
        SqlSession sqlSession = MybatisUtil.getSession();
        int update = sqlSession.update("com.mybatis.mapper.UserMapper.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
        return update;
    }

    @Override
    public int deleteUserById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSession();
        int delete = sqlSession.delete("com.mybatis.mapper.UserMapper.deleteUserById", id);
        sqlSession.commit();
        sqlSession.close();
        return delete;
    }

    @Override
    public int queryPageCount() {
        SqlSession sqlSession = MybatisUtil.getSession();
        Integer pageCount  = sqlSession.selectOne("com.mybatis.mapper.UserMapper.queryPageCount");
        sqlSession.close();
        return pageCount;
    }
}
