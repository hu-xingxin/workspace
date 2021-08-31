package com.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-19 23:46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sys_dept")
public class Dept {
    @TableId(value = "dept_id")
    private long deptId;

    private long parentId;

    private String ancestors;

    private String deptName;

    private int orderNum;

    private String createTime;

    private String updateTime;
}
