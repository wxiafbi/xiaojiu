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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    IUserservice userService;
    // 增加用户
    @PostMapping("/add")
    public ResponseMessage<User> add(@Validated @RequestBody UserDto user) {
        User user1 = userService.add(user);
        return ResponseMessage.success(user1);
    }

    @GetMapping("/greeting")
    public String get() {
        return "hello world";
    }

    @GetMapping("/{userId}")
    public ResponseMessage<User> getUser(@PathVariable Integer userId) {
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);

    }

    @PutMapping
    public ResponseMessage<User> editer(@Validated @RequestBody UserDto user) {
        User userNew = userService.editUser(user);
        return ResponseMessage.success(userNew);

    }

    @DeleteMapping("/{userId}")
    public ResponseMessage delete(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseMessage.success();

    }


}
