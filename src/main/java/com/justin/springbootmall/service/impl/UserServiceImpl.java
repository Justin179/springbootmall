package com.justin.springbootmall.service.impl;

import com.justin.springbootmall.dao.UserDao;
import com.justin.springbootmall.dto.UserRegisterRequest;
import com.justin.springbootmall.model.User;
import com.justin.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {

        return userDao.getUserById(userId);
    }
}
