package com.mybatis.mapper;

import com.mybatis.domain.SysDept;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-18 11:37
 **/
public interface DeptMapper {
    public SysDept queryDeptById(Integer id);
}
