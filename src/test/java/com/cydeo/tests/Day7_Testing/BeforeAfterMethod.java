package com.cydeo.tests.Day7_Testing;

import org.testng.annotations.*;

public class BeforeAfterMethod {


    @BeforeClass
    public void allTheSetUp(){
        System.out.println("Before Class Set up");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("WebDriver Opening the Browser");
    }

    @Test
    public void test1(){

        System.out.println("My First Test Case");

    }

    @Ignore
    @Test
    public void test2(){

        System.out.println("My Second Test Case");

    }

    @Test
    public void test3(){

        System.out.println("My Third Test Case");

    }


    @AfterMethod
    public void tearDown(){
        System.out.println("Closing Browser,Quit");
    }


    @AfterClass
    public void TheEnd(){
        System.out.println("After Class Done");
    }

}
