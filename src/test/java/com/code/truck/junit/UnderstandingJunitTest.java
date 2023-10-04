package com.code.truck.junit;

import org.junit.jupiter.api.*;

public class UnderstandingJunitTest {

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println(">>> beforeAllTests() <<<");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println(">>> afterAllTests() <<<");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println(">>> beforeEachTest() <<<");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println(">>> afterEachTest() <<<");
    }

    @Test
    public void someTest() {

        String name = String.format("%s", "Mario");

        Assertions.assertEquals("Mario", name);
    }

    @Test
    public void testingSomething() {

        String str = String.format("%s", "");

        Assertions.assertTrue(str.isEmpty());
    }
}
