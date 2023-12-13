package com.cydeo.tests.Day8_types_of_elements_2.PersonTask;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    // Perfect Test for Window Switch
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice.cydeo.com/windows");
        String creentWindow = driver.getWindowHandle();
        for (int i = 1; i<=5;i++){
            driver.findElement(By.xpath("//a[@target='_blank'][1]")).click();
            Thread.sleep(3000);
            driver.switchTo().window(creentWindow);
        }



        }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    }










