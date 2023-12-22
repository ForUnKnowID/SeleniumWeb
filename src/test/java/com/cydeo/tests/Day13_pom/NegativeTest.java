package com.cydeo.tests.Day13_pom;

import com.cydeo.pages.LoginPage;
import com.cydeo.tests.Day12_properties_Tests.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {


    @Test
    public void OpenBrowserWithConf(){

        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");


        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(username);
        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(password+ Keys.ENTER);

    }

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.userNameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("someKeyWord");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login")
        ;
    }

    @Test
    public void wrongUsernameTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.userNameInput.sendKeys("someUserName");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }










}
