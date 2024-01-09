package com.cydeo.tests.Day14_extent_reports;

import com.cydeo.pages.LoginPage;
import com.cydeo.tests.Day12_properties_Tests.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {


    @Test
    public void wrongPasswordTest(){

        // name of the test
        extentLogger = reports.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();


        loginPage.userNameInput.sendKeys("user1");
        extentLogger.info("Enter password: user1");

        loginPage.passwordInput.sendKeys("someKeyWord");
        extentLogger.info("Enter password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click login Button");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is Passed");

    }

    @Test
    public void wrongUsernameTest(){
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: someusername");
        loginPage.userNameInput.sendKeys("someUserName");

        extentLogger.info("Enter username: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("PASSED");

    }




}
