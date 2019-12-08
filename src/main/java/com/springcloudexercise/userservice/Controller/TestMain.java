package com.springcloudexercise.userservice.Controller;


import com.springcloudexercise.userservice.Entity.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMain {

    @GetMapping("/getUserInfo")
    Object getUserInfo(){
        return new UserInfo().setName("张三").setAge(25).setGender("男").setMarried('N');
    }
}
