package com.itheima.service;

import com.itheima.consumer.consumer.pojo.Order;
import com.itheima.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> findOrderByUser(String username){
        Order order = new Order();
        order.setUsername(username);
        List<Order> orders = orderMapper.select(order);
        return orders;

    }
}
