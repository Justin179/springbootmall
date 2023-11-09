package com.justin.springbootmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
    this is used to test MyExceptionHandler
 */
@RestController
public class ExceptionController {

    @RequestMapping("/testRuntimeException")
    public String testRuntimeException(){
        throw new RuntimeException("throw Runtime exception manually");
    }

    @RequestMapping("/testIllegalArgumentException")
    public String testIllegalArgumentException(){
        throw new IllegalArgumentException("throw Illegal Argument Exception manually");
    }
}
