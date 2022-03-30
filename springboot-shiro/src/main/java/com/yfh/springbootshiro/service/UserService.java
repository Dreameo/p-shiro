package com.yfh.springbootshiro.service;

import com.yfh.springbootshiro.pojo.User;

public interface UserService {

    public User queryUserById(Integer id);

    public User queryUserByName(String name);
}
