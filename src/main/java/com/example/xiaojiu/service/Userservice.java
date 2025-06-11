package com.example.xiaojiu.service;
import com.example.xiaojiu.pojo.dto.UserDto;
import com.example.xiaojiu.repository.UserRepository;
import com.example.xiaojiu.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.BeanUtils;



@Service
public class Userservice implements IUserservice {

    @Autowired
    UserRepository userRepository;

    @Override
    public void add(UserDto userDto) {
        
        // userRepository.save(userDto);
        User user_pojo = new User();
        BeanUtils.copyProperties(userDto, user_pojo);
        userRepository.save(user_pojo);

    }

}
