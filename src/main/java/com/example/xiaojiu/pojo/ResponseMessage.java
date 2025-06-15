package com.example.xiaojiu.pojo;

import org.springframework.http.HttpStatus;

// import jakarta.persistence.criteria.CriteriaBuilder.In;

public class ResponseMessage<T> {
    private Integer code;
    private String message;
    private T data;
    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<T>(HttpStatus.OK.value(), "success", data);
    }
    // 重载success方法，改为无参数
    public static <T> ResponseMessage<T> success() {
        return new ResponseMessage<T>(HttpStatus.OK.value(), "success", null);
    }
    // 重载success方法，改为自定义message
    public static <T> ResponseMessage<T> success(String message) {
        return new ResponseMessage<T>(HttpStatus.OK.value(), message, null);
    }
    // 重载success方法，改为自定义message和data
    public static <T> ResponseMessage<T> success(String message, T data) {
        return new ResponseMessage<T>(HttpStatus.OK.value(), message, data);
    }
    // 重载success方法，改为自定义code和message
    public static <T> ResponseMessage<T> success(Integer code, String message) {
        return new ResponseMessage<T>(code, message, null);
    }
    // 重载success方法，改为自定义code、message和data

    

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseMessage(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
