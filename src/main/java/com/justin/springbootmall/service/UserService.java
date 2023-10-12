package com.justin.springbootmall.service;

import com.justin.springbootmall.dto.UserLoginRequest;
import com.justin.springbootmall.dto.UserRegisterRequest;
import com.justin.springbootmall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);
}
