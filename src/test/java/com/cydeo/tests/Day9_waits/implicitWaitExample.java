package com.cydeo.tests.Day9_waits;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class implicitWaitExample {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dynamic_loading/4");

        Thread.sleep(5000);
        driver.findElement(By.id("username")).sendKeys("Mike Smith");

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
