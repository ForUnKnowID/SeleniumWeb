package com.cydeo.tests.Day12_properties_Tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase{


    @Test
    public void test1(){
        driver.get(ConfigurationReader.get("url"));
        String username  = ConfigurationReader.get("driver_username");
        String passsword  = ConfigurationReader.get("driver_password");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username+ Keys.TAB+passsword+Keys.ENTER);

    }

}
