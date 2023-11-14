package com.justin.springbootmall.test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    public void setup(){
        demoUtils = new DemoUtils();
        System.out.println("Before each setup() method called");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEquals(){
        assertEquals(6,demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(9,demoUtils.add(2,4),"2+4 must not be 9");
    }

    @Test
    void testNullAndNotNull(){
        assertNull(demoUtils.checkNull(null),"Object should be null");
        assertNotNull(demoUtils.checkNull("luv2code"),"Object should not be null");
    }

    @Test
    void testSameAndNotSame(){
        String academy = demoUtils.getAcademy();
        String academyDuplicate = demoUtils.getAcademyDuplicate();
        assertSame(academy,academyDuplicate);
    }


}
















