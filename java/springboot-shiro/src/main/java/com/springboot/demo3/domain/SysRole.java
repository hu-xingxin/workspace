package com.springboot.demo3.domain;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author huxingxin
 * @createTime 2021年08月15日 07:35:32
 * @Description
 */
@Data
public class SysRole {
    private Integer roleId;
    private String roleName;
    private String roleKey;
}
