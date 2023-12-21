package com.cydeo.tests.Day12_properties_Tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase{




    
    @Test
    public void OpenBrowserWithConf(){
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
        String userName = ConfigurationReader.get("driver_username");


        String userPassword = ConfigurationReader.get("driver_password");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(userPassword+ Keys.ENTER);




    }




}
