package com.shiro.demo2.java;

import com.shiro.demo1.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月15日 14:01:26
 * @Description 通过 .ini配置文件 获取subject 进行登录 角色 和权限验证
 */
public class ShiroTest {

    public static List<String> roles = new ArrayList<>();
    public static List<String> permits;

    static {
        String roleStr = "超级管理员,第三方养护单位,护路员,区农路办管理员,街镇农路办负责人,街镇农路办管理员,机关科室工作人员," +
                "执法单位工作人员,用户管理员,机关科室负责人,执法单位内设机构负责人,执法单位负责人(含内设机构负责人),执法单位管理员," +
                "局领导,养护科巡查员,工区巡查员,路政执法巡查员,海事处负责人,海事处工作人员,系统管理员,窗口人员";
        String[] roleArr = roleStr.split(",");
        roles = Arrays.asList(roleArr);

        String permitStr = "查询,添加,更新,删除,导出";
        String[] permitArr = permitStr.split(",");
        permits = Arrays.asList(permitArr);
    }

    public static List<User> users = new ArrayList<>();
    static {
        users.add(new User("超级管理员","55f67e8bea154e9fa023e7965c2d1359"));
        users.add(new User("永阳农路办管理员","8a79184d1fd2cc8ab019214cf3f5babb"));
    }

    public static void main(String[] args) {
        for (User user : users){
            if(login(user)){
                for (String permit : permits){
                    hasPermitted(permit);
                }
                for (String role : roles){
                    hasRole(role);
                }
            }
        }


    }

    /**
     * 根据shiro.ini配置文件 获取subject
     * @return
     */
    private static  Subject subject;
    static {
        //加载配置文件，并获取工厂
        String classpath = Class.class.getResource("/com/shiro/demo2/java/config/shiro.ini").getPath().substring(1);
        System.out.println(classpath);
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory(classpath);
        //获取安全管理者实例
        SecurityManager securityManager = factory.getInstance();
        //将安全管理者放入全局对象
        SecurityUtils.setSecurityManager(securityManager);
        //全局对象通过安全管理者生成Subject对象
        subject = SecurityUtils.getSubject();
    }

    /**
     * 登录验证
     * @param user
     * @return
     *
     * subject.isAuthenticated()  登录结果 成功返回true 失败返回false
     * 需要注意 只有登录成功 subject 才会记录用户信息
     * 如果第一次登录成功 第二次登录失败 subject.isAuthenticated() 也会返回true 记录的是上一次登录成功的结果
     * 但是如果第一次登录失败  第二次登录成功 第二次的登录结果会刷新
     */
    public static boolean login(User user){
        //封装用户的数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            //将用户的数据token 最终传递到Realm中进行对比
            subject.login(token);
            System.out.println(user.getName() + "登录成功......................");
            System.out.println(subject.isAuthenticated());
        }catch (AuthenticationException e){
            //验证错误
            System.out.println(user.getName() + "登录失败......................");
            System.out.println(subject.isAuthenticated());
            return false;
        }

        //登录结果 成功返回true 失败返回false
       return subject.isAuthenticated();
    }

    /**
     * 角色校验
     * @param role
     */
    public static void hasRole(String role){
        boolean hasRole = subject.hasRole(role);
        if(hasRole){
            System.out.println("有角色：" + role);
        }else {
//            System.out.println("没有角色：" + role);
        }
    }

    /**
     * 权限校验
     * @param permit
     */
    public static void hasPermitted(String permit){
        boolean hasPermitted = subject.isPermitted(permit);
        if(hasPermitted){
            System.out.println("有权限：" + permit);
        }else {
//            System.out.println("没有权限：" + permit);
        }
    }
}


