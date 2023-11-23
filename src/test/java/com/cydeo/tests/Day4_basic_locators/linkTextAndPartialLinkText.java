package com.cydeo.tests.Day4_basic_locators;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextAndPartialLinkText {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cydeo.com/dynamic_loading");

        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        link1.click();

        driver.close();


    }

}
