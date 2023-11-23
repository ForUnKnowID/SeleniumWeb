package com.cydeo.tests.CydeoWeb.Other;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class cydeoPracticeTool {


    @Test

    public void tool() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.get("https://practice.cydeo.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "cydeo";

        // expect the url has cydeo keyword
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("The URL Does contain the cydeo word");
        } else {
            System.out.println("The URL Does not contain the " + expectedUrl);
        }

        driver.close();


    }


    @Test
    public void verifyTitle()throws InterruptedException{
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.get("https://practice.cydeo.com");
        String expectResult = "Practice";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectResult,actualResult);
        driver.close();
    }

}
