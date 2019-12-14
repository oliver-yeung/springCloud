package com.itheima.consumer.controller;

import com.itheima.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
@Slf4j
//在类上指明统一的失败降级方法,该类所有方法返回类型要与处理失败的方返回类型一致
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("{id}")
    @HystrixCommand(fallbackMethod = "queryByIdFallback")   //用来声明一个降级逻辑的方法,对方法进行降级
    public User queryById(@PathVariable Long id){
        /*String url = "http://localhost:9091/user/"+id;

        //获取eureka中注册的user-service实例列表
        List<ServiceInstance> serviceInstancesList = discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = serviceInstancesList.get(0);
        url = "http://"+serviceInstance.getHost() + ":"+ serviceInstance.getPort() + "/user/" + id;
        return restTemplate.getForObject(url,User.class);*/
        String url = "http://user-service/user/"+id;
        User user = restTemplate.getForObject(url,User.class);
        return user;
    }

    public String queryByIdFallback(Long id){
        log.error("查询用户信息失败。id:{}",id);
        return "对不起,网络太拥挤了!";
    }

    public String defaultFallback(){
        return "默认提示: 对不起,网络太拥挤了!";
    }
}
