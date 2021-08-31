package com.shiro.demo2.java.config;

import com.shiro.demo2.java.domain.User;
import com.shiro.demo2.java.service.UserService;
import com.shiro.demo2.java.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 14:04:35
 * @Description 用来通过数据库 验证用户，和相关授权的类
 */
public class DatabaseRealm extends AuthorizingRealm {
    private UserService userService = new UserServiceImpl();

    /**
     * 授权：角色 权限
     * @param principalCollection
     * @return
     *  能进入到这里，表示账号已经通过验证了
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String)principalCollection.getPrimaryPrincipal();
        List<User> users = userService.queryUserList(new User(userName));
        //获取角色和权限
        List<String> roles = userService.queryRoleByUserId(users.get(0).getUserId());
        List<String> permits = userService.queryPermissionByUserId(users.get(0).getUserId());
        //授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //把获取到的角色和权限放进去
        authorizationInfo.addRoles(roles);//角色
        authorizationInfo.addStringPermissions(permits);//权限
        return authorizationInfo;
    }

    /**
     * 认证：用户名密码校验
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //登录时 创建的的token 存储了用户名和密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //从token里面取出用户名密码  和数据库里面的进行比对
        String userName = token.getPrincipal().toString();
        String password = new String(usernamePasswordToken.getPassword());
        List<User> users = userService.queryUserList(new User(userName, password));
        //若不匹配
        if(users.isEmpty()){
            throw new AuthenticationException();
        }

        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
       return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
