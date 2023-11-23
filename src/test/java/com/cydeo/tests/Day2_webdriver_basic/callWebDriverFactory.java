package com.cydeo.tests.Day2_webdriver_basic;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class callWebDriverFactory {

    public static void main(String[] args) {

        WebDriver driver  = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.youtube.com/");

    }

}
