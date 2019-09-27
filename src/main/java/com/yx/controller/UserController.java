package com.yx.controller;

import com.yx.bean.User;
import com.yx.common.Const;
import com.yx.common.ServerResponse;
import com.yx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liizzz
 * @start 2019-09-25 16:57
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "allusers")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllusers();
    }

    @RequestMapping(value = "login")
    @ResponseBody
    public ServerResponse login(@RequestParam("name") String username, @RequestParam("pwd") String password, HttpSession session) {
        ServerResponse response = userService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @RequestMapping(value = "logout")
    @ResponseBody
    public ServerResponse logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessWithMsg("退出成功");
    }

    @RequestMapping(value = "register")
    @ResponseBody
    public ServerResponse register(User user) {
        return userService.register(user);
    }

    @RequestMapping(value = "check_valid")
    @ResponseBody
    public ServerResponse checkValid(String str, String type) {
        return userService.checkValid(str, type);
    }

    @RequestMapping(value = "get_user_info")
    @ResponseBody
    public ServerResponse getUserInfo(HttpSession session) {
        //先判断该用户是否已经登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            //从session中返回用户信息
            return ServerResponse.createBySuccessWithData(user);
        }
        return ServerResponse.createByErrorWithMsg("用户未登录，请重新登录");
    }


}
