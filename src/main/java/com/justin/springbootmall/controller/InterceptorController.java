package com.justin.springbootmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("執行 testInterceptor()");
        return "執行 testInterceptor()";
    }

    @RequestMapping("/testInterceptor2")
    public String testInterceptor2(){
        System.out.println("執行 testInterceptor2()");
        return "執行 testInterceptor2()";
    }
}
