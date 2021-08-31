package com.mybatis;

import com.mybatis.domain.SysDept;
import com.mybatis.domain.SysUser;
import com.mybatis.service.impl.DeptServiceImpl;
import com.mybatis.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    private  UserServiceImpl userService = new UserServiceImpl();

    /**
     * 根据id查询用户
     */
    @Test
    public  void queryUserById(){
        SysUser user = userService.queryUserById(2);
        System.out.println(user);
        SysDept dept = user.getDept();
        System.out.println(dept);
    }

    /**
     * 根据ids(List)查询用户集合
     */
    @Test
    public  void queryUserByListIds(){
        List<SysUser> userList = new ArrayList<>();
        for(Long i = 110L;i<130;i++){
            SysUser user = new SysUser();
            user.setUserId(i);
            userList.add(user);
        }
        userList = userService.queryUserByListIds(userList);
        for (SysUser user:userList) {
            System.out.println(user);
        }
    }

    /**
     * 根据ids(Array)查询用户集合
     */
    @Test
    public  void queryUserByArrayIds(){
        Long[] ids= new Long[20];
        int index = 0;
        for(Long i = 110L;i<130;i++){
            ids[index]=i;
            index++;
        }
        System.out.println(ids.length);
        List<SysUser> userList = userService.queryUserByArrayIds(ids);
        for(SysUser sysUser : userList){
            System.out.println(sysUser);
        }
    }

    /**
     * 根据ids(Map)查询用户集合
     */
    public  void queryUserByMapIds(){
        List<Long> idsList = new ArrayList<>();
        for(Long i = 110L;i<130;i++){
            idsList.add(i);
        }
        Map idsMap = new HashMap<>();
        idsMap.put("ids",idsList);
        
        List<SysUser> userList = userService.queryUserByMapIds(idsMap);
        for (SysUser user:userList) {
            System.out.println(user);
        }
    }

    /**
     * 根据条件查询用户集合
     */
    @Test
    public  void queryUserList(){
        SysUser user = new SysUser();
        user.setCurrentPage(4);
        user.setPageSize(3);
        
        List<SysUser> userList = userService.queryUserList(user);

        for(SysUser sysUser : userList){
            System.out.println(sysUser);
        }

        System.out.println("当前第页:" + user.getCurrentPage() +
        " 当前页有 " + userList.size() + " 条"+
        "  每页 " + user.getPageSize() + " 条  共 " + user.getTotalPage()
        + " 页  共  " + user.getTotalCount() + "  条");
    }

    /**
     * 新增用户 会在实体类userId里面返回新增的id
     * @param
     * @return
     */
    @Test
    public  void insertUser(){
        SysUser sysUser = new SysUser();
        int i = userService.insertUser(sysUser);
        System.out.println(i);
        System.out.println(sysUser);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    public  Integer updateUser(SysUser user){
        return userService.updateUser(user);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    public  Integer deleteUserById(Integer id){
        return userService.deleteUserById(id);
    }

    /**
     * 根据id 查询部门
     */
    @Test
    public  void queryDeptById(){
        DeptServiceImpl deptService = new DeptServiceImpl();
        SysDept dept = deptService.queryUserById(101);
        System.out.println(dept);
        System.out.println(dept.getUserList());
    }
}
