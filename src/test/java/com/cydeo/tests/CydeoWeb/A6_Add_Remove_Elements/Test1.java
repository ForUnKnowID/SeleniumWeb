package com.cydeo.tests.CydeoWeb.A6_Add_Remove_Elements;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {

    protected WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/drag_and_drop_circles");
        String eResult = "Drag and Drop Circles";
        Assert.assertEquals(eResult,driver.getTitle(),"Verifying the title are the same");


    }


    @Test
    public void test1(){
        Actions actions = new Actions(driver);
        WebElement circle = driver.findElement(By.id("draggable"));
        WebElement bigCircle = driver.findElement(By.id("droptarget"));
        actions.moveToElement(circle).clickAndHold().moveToElement(bigCircle).release().perform();
        System.out.println(bigCircle.getText());
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }







}
