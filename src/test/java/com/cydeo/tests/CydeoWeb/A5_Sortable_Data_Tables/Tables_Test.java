package com.cydeo.tests.CydeoWeb.A5_Sortable_Data_Tables;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tables_Test {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
    driver= WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tear() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    //Making sure Al the texts are display and correct
    @Test
    public void test1(){
        Assert.assertTrue(driver.getTitle().equals("Data Tables"));


        String firstTabAResult = driver.findElement(By.xpath("//*[.='Data Tables']")).getText();





    }


}
