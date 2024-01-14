package com.cydeo.tests.Day15_review;

import com.cydeo.pages.ContactInfoPage;
import com.cydeo.pages.ContactsPage;
import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.tests.Day12_properties_Tests.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {



    @Test
    public void contactDetailsTest(){

        extentLogger = reports.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.getProperty("salesmanager_username");
        String password = ConfigurationReader.getProperty("salesmanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login ass a Sales Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to -->Customers > Contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");

        ContactsPage contactsPage = new ContactsPage();
        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String eFullName = "Mariam Brackstone";
        String aFullName = contactInfoPage.fullName.getText();

        Assert.assertEquals(aFullName,eFullName,"Verify full Name");

        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","Verify the email");

        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","Verify the phone number");
        extentLogger.pass("PASSED");



    }





}
