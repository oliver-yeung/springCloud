package com.itheima.consumer.controller;

import com.itheima.consumer.client.UserClient;
import com.itheima.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ConsumerFeignController {

    @Autowired
    public UserClient userClient;

    @GetMapping("/{username}")
    public User queryById(@PathVariable("username") String username){
        return userClient.findOrderByUser(username);

    }
}
