package com.justin.springbootmall.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void should_Add_When_() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        assertEquals(3,result);
    }

    @Test
    void should_Divide_When_() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class,()->{
            calculator.divide(1,0);
        });
    }
}