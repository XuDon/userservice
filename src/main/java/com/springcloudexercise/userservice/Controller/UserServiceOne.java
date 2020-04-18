package com.springcloudexercise.userservice.Controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import com.springcloudexercise.baseservice.FeignInterface.UserServiceOneFeign;
import com.springcloudexercise.baseservice.FeignInterface.UserServiceTwoFeign;
import com.springcloudexercise.userservice.Entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserServiceOne {

    private UserServiceTwoFeign userServiceTwoFeign;

    @Autowired
    UserServiceOne(UserServiceTwoFeign userServiceTwoFeign){
        this.userServiceTwoFeign = userServiceTwoFeign;
    }

    /**
     * 1、默认超时时间大于等于1S
     * 2、参数个数保持一致
     */
    @HystrixCommand(fallbackMethod="fallbackFunc")
    @GetMapping("/getUserInfo")
    Object getUserInfo() throws InterruptedException {
        Thread.sleep(800);
        return new UserInfo().setName("张三1").setAge(25).setGender("男").setMarried('N');
    }

    @HystrixCommand(defaultFallback="fallbackFunc")//,ignoreExceptions = ArithmeticException.class 忽略的异常类型
    @GetMapping("/getUserInfo/{age}")
    Object getUserInfo(@PathVariable int age) throws InterruptedException {
        int index = 10/age;
        return new UserInfo().setName("李四").setAge(index).setGender("男").setMarried('N');
    }




    @PostMapping("/addUserInfo")
    Object addUserInfo(@RequestBody Object user){
        return userServiceTwoFeign.addUserInfo(user);
    }

    Object fallbackFunc(){
        return "我是请求超时/出现异常时的降级方法";
    }
}
