package com.servlet.mapper;

import com.servlet.domain.User;
import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月16日 10:09:02
 * @Description
 */
public interface UserMapper {
    public List<User> queryUserList(User user);
    public List<String> queryRoleByUserId(Long userId);
    public List<String> queryPermissionByUserId(Long userId);
    public Integer insertUser(User user);
}
