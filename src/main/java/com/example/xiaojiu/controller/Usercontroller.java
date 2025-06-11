package com.example.xiaojiu.controller;
// import com.example.xiaojiu.pojo.User;
import com.example.xiaojiu.pojo.dto.UserDto;
import com.example.xiaojiu.service.IUserservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    IUserservice userService;
    // 增加用户
    @PostMapping("path")
    public String add(@RequestBody UserDto user) {
        // System.out.println(user.toString());
        userService.add(user);
        return "success";

    }

}
