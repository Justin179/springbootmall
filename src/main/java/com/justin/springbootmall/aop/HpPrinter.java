package com.justin.springbootmall.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer{

    @Value("${printer.name}")
    private String name;

    @Override
    public void print(String message) {
        System.out.println("print "+name);
    }

    @Override
    public void printColor(String message) {
        System.out.println("print color "+name);
    }
}
