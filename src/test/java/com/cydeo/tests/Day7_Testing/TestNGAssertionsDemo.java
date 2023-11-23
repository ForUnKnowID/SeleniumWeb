package com.cydeo.tests.Day7_Testing;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {


    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }


    @Test
    public void test1 (){
        System.out.println("First Test");
        Assert.assertEquals("title","title ");

        System.out.println("Second Test");
        Assert.assertEquals("url","url");

    }

    @Test
    public void test2(){
        Assert.assertEquals("test2","test2","The 2 tests are not equal");
    }

    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle="Cybertek";

        Assert.assertTrue(expectedTitle.contains(actualTitle),"Test 2 (The title are equal)");
    }

    @Test
    public void test4(){
        String email ="Bilal@gmail.com";
        Assert.assertTrue(email.contains("@"),"The email @ is not there ");

    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1,"Verify that 0 is not greater then 1");
    }

    @Test
    public void test6(){

    }

    @AfterClass
    public void done(){
        System.out.println("Browser Close");
    }




}
