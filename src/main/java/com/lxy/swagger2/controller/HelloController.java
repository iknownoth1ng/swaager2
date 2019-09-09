package com.lxy.swagger2.controller;

import com.lxy.swagger2.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: swagger2-demo
 * @description:
 * @author: lxy
 * @create: 2019-09-07 18:27
 */

@RestController
public class HelloController {


    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/user")
    public User user(){
        return new User();
    }
    @ApiOperation("hello控制类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("传入的参数用户名") String username){
        return "hello2"+username;
    }

    @ApiOperation("Post控制类")
    @PostMapping("/postt")
    public User post(@ApiParam("传入的参数用户名") User user){
        return user;
    }
}
