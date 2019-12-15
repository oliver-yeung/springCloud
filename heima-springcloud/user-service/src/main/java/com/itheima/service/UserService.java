package com.itheima.service;


import com.itheima.mapper.UserMapper;
import com.itheima.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findOrderByUser(String username){
        return userMapper.selectByPrimaryKey(username);
    }


}
