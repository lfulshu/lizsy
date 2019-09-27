package com.yx.service.impl;

import com.yx.bean.User;
import com.yx.common.Const;
import com.yx.common.ServerResponse;
import com.yx.dao.UserMapper;
import com.yx.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liizzz
 * @start 2019-09-25 16:56
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllusers() {

        return userMapper.getAllusers();

    }

    @Override
    public ServerResponse login(String username, String password) {
        int count = userMapper.checkByName(username);
        if (count == 0) {
            return ServerResponse.createByErrorWithMsg("用户名不存在");
        }
        User user = userMapper.getUserByLogin(username, password);
        if (user == null) {
            return ServerResponse.createByErrorWithMsg("密码错误");
        }
        System.out.println(user);
        user.setPassword(null);
        return ServerResponse.createBySuccess("登录成功", user);
    }

    @Override
    public ServerResponse register(User user) {
        ServerResponse validResponse = checkValid(user.getUsername(), Const.USER_NAME);
        if (!validResponse.isSuccess()){

        }
        return null;
    }

    @Override
    public ServerResponse checkValid(String str, String type) {

        if (StringUtils.isNotBlank(str)) {
            if (type.equals(Const.USER_NAME)) {
                int count = userMapper.checkByName(str);
                if (count > 0) {
                    return ServerResponse.createByErrorWithMsg("user already exist");
                }
            }
            if (type.equals(Const.EMAIL)) {
                int count = userMapper.checkByEmail(str);
                if (count > 0) {
                    return ServerResponse.createByErrorWithMsg("email already exist");
                }
            }
            return ServerResponse.createBySuccessWithMsg("校验成功");
        }
        return ServerResponse.createByErrorWithMsg("参数错误");
    }

}
