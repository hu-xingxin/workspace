package com.spring.demo1.mapper;

import com.spring.demo1.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 10:09:02
 * @Description
 */
@Mapper
public interface UserMapper {
    public List<User> queryUserList(User user);
    public List<String> queryRoleByUserId(Long userId);
    public List<String> queryPermissionByUserId(Long userId);
    public Integer insertUser(User user);
}
