package com.yx.service;

import com.yx.bean.User;
import com.yx.common.ServerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liizzz
 * @start 2019-09-25 16:56
 */
@Service
public interface UserService {

    List<User> getAllusers();

    ServerResponse login(String username, String password);

    ServerResponse register(User user);

    ServerResponse checkValid(String str, String type);
}
