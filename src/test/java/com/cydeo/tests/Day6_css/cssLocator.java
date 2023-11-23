package com.cydeo.tests.Day6_css;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cssLocator {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/multiple_buttons");
        driver.findElement(By.cssSelector("#disappearing_button")).click();




    }
}
