package com.justin.springbootmall.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HpPrinterTest {
    /* 這是在測試，使用aop的方式，來測量每個方法的執行時間
    print print text
    this method takes 3013ms to execute

    print color print text in color
    this method takes 4010ms to execute
     */
    @Autowired
    Printer printer;

    @Test
    void print() {
        printer.print("print text");
    }

    @Test
    void printColor() {
        printer.printColor("print text in color");
    }

}