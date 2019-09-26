package com.yx.dao;

import com.yx.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liizzz
 * @start 2019-09-25 16:38
 */
@Repository
public interface UserMapper {
    /**
     * 根据用户名获取用户数
     */
    int checkByName(String name);

    /**
     * @return 获取所有的用户信息
     */
    List<User> getAllusers();

    /**
     * 登录时匹配数据库中的账号密码
     */
    User getUserByLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 根据email获取用户
     */
    int checkByEmail(String email);
}
