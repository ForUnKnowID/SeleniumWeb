package com.cydeo.tests.Day9_popups_tabs_frames.Practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframe {

    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice.cydeo.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement inputBox = driver.findElement(By.xpath("//body[@data-id='mce_0']"));
        inputBox.clear();
        inputBox.sendKeys("Mike Smith");

        //Goes back to first frame(main html)
        //goes back to first frame useful when we have switched multiple frames

        driver.switchTo().defaultContent();

        // 2 Switching with INDEX
        driver.switchTo().frame(0);

        // clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith With Index");

        driver.switchTo().parentFrame();
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith With Web Element");



    }


    @Test
    public void test2(){
        driver.get("https://practice.cydeo.com/nested_frames");

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //switching right with index
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());



    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
