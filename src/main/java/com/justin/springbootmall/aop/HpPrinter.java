package com.justin.springbootmall.aop;

import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer{

    @Override
    public void print(String message){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("print "+message);
    }

    @Override
    public void printColor(String message) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("print color "+message);
    }
}
