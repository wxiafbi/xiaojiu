package com.example.xiaojiu.controller;
import com.example.xiaojiu.pojo.ResponseMessage;
import com.example.xiaojiu.pojo.User;
// import com.example.xiaojiu.pojo.User;
import com.example.xiaojiu.pojo.dto.UserDto;
import com.example.xiaojiu.service.IUserservice;

import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    IUserservice userService;
    // 增加用户
    @PostMapping()
    public ResponseMessage<User> add(@RequestBody UserDto user) {
        User user1 = userService.add(user);
        return ResponseMessage.success(user1);
    }

    @GetMapping("/greeting")
    public String get() {
        return "hello world";
    }

}
