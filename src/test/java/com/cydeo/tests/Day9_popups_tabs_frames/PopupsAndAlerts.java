package com.cydeo.tests.Day9_popups_tabs_frames;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    // I use Alert class to handle the js popups
    // Alert alert = driver.switchTo().alert();
    // alert.accept();  alert.dismiss(); alert.senkeys("")   alert.getText();

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    @Test
    @Ignore
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

    }

    @Test
    public void test2()throws InterruptedException{
        driver.get("http://practice.cydeo.com/javascript_alerts");

        driver.findElement(By.xpath("//button[1]")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.xpath("//button[1]")).click();
        Thread.sleep(3000);
        alert.dismiss();

    }


    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
