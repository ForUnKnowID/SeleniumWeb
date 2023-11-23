package com.cydeo.tests.Day9_popups_tabs_frames.Practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAlerts {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }


    @Test
    public void test1(){
        String expectResult = "Alerts";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectResult,"The Title has problem");

        WebElement JSAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        JSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();


        String expectTextBtn1 = "You successfully clicked an alert";
        String actualTextBtn1 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectTextBtn1,actualTextBtn1,"The Text Button 1");

        System.out.println("Test 1 Done");


    }

    @Test
    public void test2()throws InterruptedException{
        WebElement JSConfirmBtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        JSConfirmBtn.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String expectTextR = "You clicked: Cancel";
        String actualTextR = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectTextR,actualTextR,"The cancel text has issue");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alert.accept();
        

    }




    @AfterMethod
    public void tearDown()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }

}
