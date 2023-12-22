package com.cydeo.tests.Day13_pom;

import com.cydeo.pages.LoginPage;
import com.cydeo.tests.Day12_properties_Tests.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoreManager(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.getProperty("storemanager_username");
        String password = ConfigurationReader.getProperty("storemanager_password");

//        loginPage.userNameInput.sendKeys(username);
//        loginPage.passwordInput.sendKeys(password);
//        loginPage.loginBtn.click();

        loginPage.login(username,password);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://qa1.vytrack.com/");


    }

    @Test
    public void loginAsStoreManager2(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://qa1.vytrack.com/");



    }






}
