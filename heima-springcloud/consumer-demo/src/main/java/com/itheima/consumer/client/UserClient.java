package com.itheima.consumer.client;

import com.itheima.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service") //声明这是一个Fegin客户端,同时通过value属性指定服务名称
//Feign通过动态代理帮我们实现此接口的实现类
public interface UserClient {

    //采用SpringMVC注解,Fegin根据注解帮我们生成url
    @GetMapping("/user/{username}") //  "/user"是Feign需要拼接的可访问的地址
    User findOrderByUser(@PathVariable("username") String username);

}
