package com.cydeo.tests.Day12_properties_Tests;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {


    @Test
    public void test1(){

        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }


    @Test
    public void test2(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com");

    }

    @Test
    public void test3(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.amazon.com");
    }


}
