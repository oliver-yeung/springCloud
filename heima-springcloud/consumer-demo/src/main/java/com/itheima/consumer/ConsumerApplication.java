package com.itheima.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@SpringBootApplication //springBoot注解
@EnableDiscoveryClient  //开启Eureka
@EnableCircuitBreaker   //开启熔断*/
@SpringCloudApplication  //三合一注解代替上面三个注解
@EnableFeignClients //开启Feign功能
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced //Ribbon负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

