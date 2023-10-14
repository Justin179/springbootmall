package com.justin.springbootmall.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.justin.springbootmall.aop.HpPrinter.*(..))")
    public void before(){
        System.out.println("-- this is aop before --");
    }

    @After("execution(* com.justin.springbootmall.aop.HpPrinter.*(..))")
    public void after(){
        System.out.println("-- this is aop after --");
    }
}
