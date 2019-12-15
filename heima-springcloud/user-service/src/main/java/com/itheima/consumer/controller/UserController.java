package com.itheima.consumer.controller;

import com.itheima.consumer.client.OrderClient;
import com.itheima.consumer.pojo.Order;
import com.itheima.consumer.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderClient orderClient;

    @RequestMapping("/{username}")
    public User findOrderByUser(@PathVariable String username){

       User user = userService.findOrderByUser(username);
        List<Order> orderByUsername = orderClient.findOrderByUsername(username);
        user.setOrderList(orderByUsername);
        return user;
    }
}
