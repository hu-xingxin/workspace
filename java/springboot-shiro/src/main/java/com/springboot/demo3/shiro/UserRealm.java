package com.springboot.demo3.shiro;

import com.springboot.demo3.domain.SysUser;
import com.springboot.demo3.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userService;

	/**
	 * 完成认证的方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginName = token.getPrincipal().toString();
		// 根据用户名查询用户是否存在
		SysUser user = userService.queryUserByLoginName(loginName);
		// 返回null说明用户不存在
		if (null == user) {
			throw new AuthenticationException();
		}
		// 根据用id去查询用户拥有哪些角色
		List<String> roles = userService.queryRoleListByUserId(user.getUserId());
		// 根据用id查询用户拥有哪些权限
		List<String> permissions = userService.queryPermissionListByUserId(user.getUserId());

		ActiveUser activeUser = new ActiveUser(user, roles, permissions);
		/**
		 * 参数1:用户身份传到doGetAuthorizationInfo里面getPrimaryPrincipal()的对象或者subject.getPrincipal()
		 * 参数2:hashedCredentials 加密之后的密码
		 * 参数3:credentialsSalt 盐
		 * 参数4当前类名
		 */
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());//盐
		return new SimpleAuthenticationInfo(activeUser, user.getPassword(), credentialsSalt, getName());
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 根据用户名去查询用户拥有哪些角色
		List<String> roles = activeUser.getRoles();
		if (!roles.isEmpty()) {
			// 添加角色
			info.addRoles(roles);
		}
		// 根据用户名查询用户拥有哪些权限
		List<String> permissions = activeUser.getPermissions();
		// 添加权限
		if (!permissions.isEmpty()) {
			// 添加角色
			info.addStringPermissions(permissions);
		}
		return info;
	}

}
