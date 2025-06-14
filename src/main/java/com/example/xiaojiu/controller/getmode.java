package com.example.xiaojiu.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class getmode {
    @GetMapping("path")
    public String getMode() {
        return "getMode";
    }

}
