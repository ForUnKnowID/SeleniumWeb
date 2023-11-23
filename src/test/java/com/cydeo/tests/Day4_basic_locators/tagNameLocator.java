package com.cydeo.tests.Day4_basic_locators;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class tagNameLocator {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/sign_up");


    }
}
