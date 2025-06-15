package com.example.xiaojiu.service;

import com.example.xiaojiu.pojo.User;
import com.example.xiaojiu.pojo.dto.UserDto;

public interface IUserservice {
    User add(UserDto userDto);
    User getUser(Integer userId);
    User editUser(UserDto userDto);
    void deleteUser(Integer userId);

}
