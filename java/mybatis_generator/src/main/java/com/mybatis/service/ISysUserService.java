package com.mybatis.service;

import com.mybatis.domain.SysUser;
import com.mybatis.domain.SysUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-20 15:18
 **/
public interface ISysUserService {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long user_id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long user_id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}
