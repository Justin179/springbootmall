package com.justin.springbootmall.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Around("execution(* com.justin.springbootmall.aop.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String shortString = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("executing @Around on method: "+shortString);

        long begin = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Duration: "+ duration/1000.0 + " seconds");


        return proceed;
    }


    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }
}
