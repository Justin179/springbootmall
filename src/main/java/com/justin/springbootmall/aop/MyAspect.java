package com.justin.springbootmall.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.justin.springbootmall.aop.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Date startTime = new Date();
        // 執行切入點的方法
        Object obj = pjp.proceed();

        Date endTime = new Date();
        long executionTime = endTime.getTime() - startTime.getTime();
        System.out.println("this method takes "+executionTime+"ms to execute");
        return obj;
    }


}
