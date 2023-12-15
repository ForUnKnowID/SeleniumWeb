package com.cydeo.tests.Day10_actions_js;

import com.cydeo.tests.Day9_popups_tabs_frames.Practice.Iframe;
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
    public void clickWithJS() throws InterruptedException {
        driver.get("http://practice.cydeo.com/");
        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click",dropDown);
        Thread.sleep(3000);

    }

    @Test
    public void typeWithJS() throws InterruptedException {
        driver.get("http://practice.cydeo.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text = "Hello Disable input";
        jse.executeScript("arguments[0].setAttribute('value','"+text+"')",inputBox);

    }

    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cydeo.com/infinite_scroll");
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");
    }

    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",eng);
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
