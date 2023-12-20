package com.cydeo.tests.Day12_properties_Tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){

        String browserType = ConfigurationReader.get("browser");

        System.out.println("browserType = " + browserType);

        String url = ConfigurationReader.get("url");

        System.out.println("url = " + url);




    }

    @Test
    public void OpenBrowserWithConf(){
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
        String userName = ConfigurationReader.get("driver_username");


        String userPassword = ConfigurationReader.get("driver_password");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(userPassword+Keys.ENTER);




    }


}
