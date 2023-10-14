package com.justin.springbootmall.controller;

import com.justin.springbootmall.aop.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrinterController {

    @Autowired
    private Printer printer;

    @RequestMapping("/print")
    public void print(){
        printer.print("");
        printer.printColor("");
    }
}
