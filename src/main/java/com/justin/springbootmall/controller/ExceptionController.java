package com.justin.springbootmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @RequestMapping("/testException")
    public String testException(){
        throw new RuntimeException("throw Runtime exception manually");
    }

    @RequestMapping("/testException2")
    public String testException2(){
        throw new IllegalArgumentException("throw Illegal Argument Exception manually");
    }
}
