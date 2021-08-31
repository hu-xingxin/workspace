package com.servlet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 09:48:02
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Long roleId;
    private String roleName;
    private String roleKey;
}
