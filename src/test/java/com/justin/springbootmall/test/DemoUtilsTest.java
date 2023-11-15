package com.justin.springbootmall.test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

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
        // find out if the object reference is the same
        assertSame(academy,academyDuplicate);
    }

    @Test
    void testTrueAndFalse(){
        // test if 10 is greater than 5
        assertTrue(demoUtils.isGreater(10,5));
    }

    // 這說明了，這兩個陣列是兩個不同的物件，只是剛好他們的內容完全一樣
    @Test
    void testArrayEquals(){
        String[] stringArray = {"A","B","C"};
        assertArrayEquals(stringArray,demoUtils.getFirstThreeLettersOfAlphabet(),"2 arrays should be the same"); // contents
        assertNotSame(stringArray,demoUtils.getFirstThreeLettersOfAlphabet()); // object reference
    }

    @Test
    void testIterableEquals(){
        List<String> list = List.of("luv", "2", "code");
        assertIterableEquals(list,demoUtils.getAcademyInList()); // 這也是在看list中的內容
        assertLinesMatch(list,demoUtils.getAcademyInList());
        assertNotSame(list,demoUtils.getAcademyInList()); // object reference
    }

    @Test
    void testThrowsAndDoesNotThrow(){
        assertThrows(Exception.class, ()->demoUtils.throwException(-1));
        assertDoesNotThrow(()->demoUtils.throwException(5));
    }

    @DisplayName("用來確保方法的執行時間上限")
    @Test
    void testTimeout(){
        assertTimeoutPreemptively(Duration.ofSeconds(3),()->demoUtils.checkTimeout(),
                "method should execute within 3 seconds");
    }

}
















