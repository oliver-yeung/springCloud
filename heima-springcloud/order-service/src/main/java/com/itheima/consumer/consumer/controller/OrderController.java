package com.itheima.consumer.consumer.controller;

import com.itheima.consumer.consumer.pojo.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/{username}")
    public List<Order> findOrderByUsername(@PathVariable("username") String username){
        return orderService.findOrderByUser(username);
    }
}
