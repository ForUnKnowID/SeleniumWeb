package com.cydeo.tests.Day10_actions_js;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptDemo {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }



    @Test
    public void clickWithJs(){
        driver.get("https://practice.cydeo.com/");
        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click;",dropDownLink);



    }

    @Test
    public void typeWithJs(){
        driver.get("https://practice.cydeo.com/dynamic_controls");

        WebElement inputBox= driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        String text = "Hello Disable Input";
        jsc.executeScript("argument[0].setAttribute('value','"+text+"')",inputBox);
        Actions j = new Actions(driver);
    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
      //  driver.get("https://practice.cydeo.com/infinite_scroll");
        driver.get("https://Amazon.com");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        Thread.sleep(3000);

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
