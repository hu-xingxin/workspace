package com.springboot.demo3.shiro;

import com.springboot.demo3.domain.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 封装对象 以及所属角色和权限
 */
public class ActiveUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private SysUser user;//用户
	
	private List<String> roles;//角色
	
	private List<String> permissions;//权限

}
