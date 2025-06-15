package com.example.xiaojiu.service;

import com.example.xiaojiu.pojo.dto.UserDto;
import com.example.xiaojiu.repository.UserRepository;
import com.example.xiaojiu.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils; // 替换 Apache BeanUtils

@Service
public class Userservice implements IUserservice {
    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDto userDto) {

        User user_pojo = new User();
        // BeanUtils.copyProperties(userDto, user_pojo);
        BeanUtils.copyProperties(userDto, user_pojo);
        return userRepository.save(user_pojo);

    }
    @Override
    public User editUser(UserDto userDto) {
        User user_pojo = new User();
        BeanUtils.copyProperties(userDto, user_pojo);
        return userRepository.save(user_pojo);

    }
        

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在");
        });

    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }



}
