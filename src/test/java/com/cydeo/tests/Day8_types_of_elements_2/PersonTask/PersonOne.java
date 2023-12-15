package com.cydeo.tests.Day8_types_of_elements_2.PersonTask;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PersonOne {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cydeo.com/multiple_buttons");
        List<WebElement> webElementList = driver.findElements(By.tagName("button"));
        for (WebElement webElement : webElementList) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    @Test
    public void test2(){
        
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
