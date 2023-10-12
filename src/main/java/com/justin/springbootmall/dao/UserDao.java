package com.justin.springbootmall.dao;

import com.justin.springbootmall.dto.UserRegisterRequest;
import com.justin.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
