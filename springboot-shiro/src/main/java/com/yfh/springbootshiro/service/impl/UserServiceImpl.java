package com.yfh.springbootshiro.service.impl;

import com.yfh.springbootshiro.mapper.UserMapper;
import com.yfh.springbootshiro.pojo.User;
import com.yfh.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
