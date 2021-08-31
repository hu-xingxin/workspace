package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatisplus.domain.SysDept;
import com.mybatisplus.mapper.DeptMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private DeptMapper deptMapper;

    @Test
    void contextLoads() {
        SysDept dept = deptMapper.selectById(100);
        System.out.println(dept);
    }

    @Test
    void getDept(){
        QueryWrapper<SysDept> deptWrapper = new QueryWrapper<>();
        deptWrapper.eq("dept_id",100);
        List<SysDept> depts = deptMapper.selectList(deptWrapper);
        for (SysDept dept : depts) {
            System.out.println(dept);
        }
    }

}
