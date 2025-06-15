package com.example.xiaojiu.pojo.dto;

import org.hibernate.validator.constraints.Length;

// import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotEmpty;

public class UserDto {

    private Integer userId;
    @NotBlank(message = "用户名不能为空")
    // @NotEmpty
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 12, message = "密码长度必须在6-16位之间")
    private String password;
    @Email(message = "邮箱格式不正确")
    private String email;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
