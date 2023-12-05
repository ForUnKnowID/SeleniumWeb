package com.cydeo.tests.Day9_popups_tabs_frames;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cydeo.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith");
    }

    @Test
    public void test2(){
        driver.get("https://practice.cydeo.com/nested_frames");
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());


        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }



    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
