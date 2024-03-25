package com.busycoder.demo3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static  org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private  Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("it will run only once for all the test case");
    }

    @BeforeEach
    void setUp() {
        calculator=new Calculator();
    }

    @DisplayName("add test")
    @Test
    void addTest() {
       assertEquals(4, calculator.add(2,2));
    }


    @DisplayName("mul test")
    @Test
    void mulTest() {
       assertEquals(40, calculator.mul(2,20));
    }

    @EnabledOnJre(JRE.JAVA_15)
    //@EnabledOnOs(OS.LINUX)
   // @Disabled
    @DisplayName("div test")
    @Test
    void divTest() {
        assertEquals(10, calculator.div(20,2));
    }

    @DisplayName("div test failed with ex")
    @Test
    void divTestWithEx() {
        assertThrows(ArithmeticException.class,()->calculator.div(40,0));
    }

    @AfterEach
    void tearDown() {
       calculator=null;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("at end ");
    }


}