package com.cydeo.tests.Day7_type_of_elements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttirubeTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/radio_buttons");

        // located the element by id, make sure it is selected
        WebElement blueBtnLocated = driver.findElement(By.id("blue"));
        blueBtnLocated.getAttribute("value");


        System.out.println(blueBtnLocated.getAttribute("type"));

    }


}
