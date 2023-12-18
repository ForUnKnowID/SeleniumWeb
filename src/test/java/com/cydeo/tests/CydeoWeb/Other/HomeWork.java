package com.cydeo.tests.CydeoWeb.Other;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class HomeWork {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



    @Test
    public void test1(){
        driver.get("https://practice.cydeo.com/hovers");
        Actions actions = new Actions(driver);
        List<WebElement> allElement = driver.findElements(By.xpath("(//div[@class='figure'])"));
        actions.moveToElement(driver.findElement(By.xpath("(//div[@class='figure'])[1]"))).perform();


        for (int i = 0; i < allElement.size(); i++) {
            
        }
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
