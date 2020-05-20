package com.mowcoder.Luntan.service;

import com.mowcoder.Luntan.dao.UserMapper;
import com.mowcoder.Luntan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
