package com.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.domain.Dept;
import com.mybatisplus.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * @author huxingxin
 * @createTime 2021年08月21日 22:37:03
 * @Description
 */
@Service
public class DeptServiceIml extends ServiceImpl<BaseMapper<Dept>,Dept> implements DeptService {
}
