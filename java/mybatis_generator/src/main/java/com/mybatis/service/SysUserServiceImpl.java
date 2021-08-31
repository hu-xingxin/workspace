package com.mybatis.service;

import com.mybatis.domain.SysDept;
import com.mybatis.domain.SysUser;
import com.mybatis.domain.SysUserExample;
import com.mybatis.mapper.SysUserMapper;
import com.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-20 15:18
 **/
public class SysUserServiceImpl implements ISysUserService{
    @Override
    public int countByExample(SysUserExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(SysUserExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long user_id) {
        return 0;
    }

    @Override
    public int insert(SysUser record) {
        return 0;
    }

    @Override
    public int insertSelective(SysUser record) {
        return 0;
    }

    @Override
    public List<SysUser> selectByExample(SysUserExample example) {
        return null;
    }

    @Override
    public SysUser selectByPrimaryKey(Long user_id) {
        SqlSession sqlSession = MybatisUtil.getSession();
        SysUser user = sqlSession.selectOne("com.mybatis.mapper.SysUserMapper.selectByPrimaryKey",user_id);
        sqlSession.close();
        return user;
    }

    @Override
    public int updateByExampleSelective(SysUser record, SysUserExample example) {
        return 0;
    }

    @Override
    public int updateByExample(SysUser record, SysUserExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return 0;
    }
}
