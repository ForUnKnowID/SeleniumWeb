package com.cydeo.tests.Day7_type_of_elements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElements {



    @Test
    public void test1(){
        // set up the driver selected chrome, maximize it, going to the url
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/radio_buttons");

        //creat element and located the greenbtn
        WebElement greenBtn = driver.findElement(By.id("green"));

        Assert.assertFalse(greenBtn.isEnabled(),"Verifying the green btn is NOT enabled");
        driver.close();




    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/dynamic_controls");

        WebElement EnableBtn = driver.findElement(By.cssSelector("button[onclick='swapInput()']"));
        EnableBtn.sendKeys("same messages");




    }


}
