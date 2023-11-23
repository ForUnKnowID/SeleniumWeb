package com.cydeo.tests.Day7_type_of_elements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class classTest {
    @Test
    public void test1() throws InterruptedException{
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/dynamic_loading/1");

        WebElement emailBtn = driver.findElement(By.id("username"));
        Assert.assertFalse(emailBtn.isDisplayed(),"The Email Btn is not showed on the screen");

        WebElement startBtn = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
        startBtn.click();

        Thread.sleep(8000);
        Assert.assertTrue(emailBtn.isDisplayed(),"The emailBtn is showed");
        driver.close();

    }



}