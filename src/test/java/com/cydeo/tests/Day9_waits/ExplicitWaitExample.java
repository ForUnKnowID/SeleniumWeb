package com.cydeo.tests.Day9_waits;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExample {


    WebDriver driver;

    @Test
    public void t(){
        driver= WebDriverFactory.getDriver("chrome");


    }
}
