package com.springcloudexercise.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.springcloudexercise.baseservice.FeignInterface"})
public class UserserviceApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication1.class, args);
    }

}
