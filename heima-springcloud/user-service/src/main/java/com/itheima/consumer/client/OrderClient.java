package com.itheima.consumer.client;

import com.itheima.consumer.pojo.Order;
import com.itheima.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("order-service")
public interface OrderClient {

    @GetMapping("/order/{username}")
    public List<Order> findOrderByUsername(@PathVariable("username") String username);
}
