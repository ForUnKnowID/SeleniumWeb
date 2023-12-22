package com.cydeo.tests.Day13_pom;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest {


    @Test
    public void OpenBrowserWithConf(){

        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");


        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(username);
        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(password+ Keys.ENTER);

    }

    @Test
    public void wrongPasswordTest(){



        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys("user1");
        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys("somepassdq"+ Keys.ENTER);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://qa1.vytrack.com");
    }








}
