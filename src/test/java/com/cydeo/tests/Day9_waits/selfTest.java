package com.cydeo.tests.Day9_waits;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class selfTest {


    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }



    // test 4
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dynamic_loading/4");
        System.out.println(driver.findElement(By.xpath("//div[@id='finish']")).getText());
    }

    // test 3
    @Test
    public void test2(){
        driver.get("https://practice.cydeo.com/dynamic_loading/3");

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
