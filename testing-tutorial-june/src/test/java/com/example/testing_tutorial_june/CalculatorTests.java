package com.example.testing_tutorial_june;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTests {

//    Calculator c = new Calculator();

    @Autowired Calculator c;

    @BeforeAll
    public static void setup() {
        System.out.println("This is executed before the test class is loaded");
    }

    @BeforeEach
    public void beforeEveryTest() {
        System.out.println("This is exeucted before every test");
    }

    @Test
    public void testAdd() {
        System.out.println("Test 1");
        int actual = c.add(6,5);
        int expected = 11;
        Assertions.assertEquals(expected,actual,"Add is not working fine");
    }

    @Test
    public void testIsEvenWhenInputIsOdd() {
        System.out.println("Test 2");
        boolean actual = c.isEven(23);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testIsEvenWhenInputIsEven() {
        System.out.println("Test 3");
        boolean actual = c.isEven(20);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMultiple() {
        System.out.println("Test 4");
        int actual = c.multiply(3,4);
        int expected = 12;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testSubtract() {
        System.out.println("Test 5");
        int actual = c.subtract(4,5);
        int expected = -1;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testSumManyNumbers() {
        System.out.println("Test 6");
        int actual = c.sumManyNumbers(3,4,5,6);
        int expected = 18;
        Assertions.assertEquals(expected,actual);
    }

    @AfterEach
    public void afterEveryTestCase() {
        System.out.println("This runs every test case");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("This is executed after all the tests in this class");
    }
}
