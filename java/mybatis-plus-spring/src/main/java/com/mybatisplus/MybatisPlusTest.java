package com.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatisplus.domain.Dept;
import com.mybatisplus.mapper.DeptMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月21日 22:39:18
 * @Description
 */
public class MybatisPlusTest {
    @Test
    public void mybatisPlusTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-*.xml");
        DeptMapper deptMapper = context.getBean(DeptMapper.class);
        Dept dept = deptMapper.selectById(100);
        System.out.println(dept);
    }
}
