package com.cydeo.tests.CydeoWeb.Other;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRMTest {




    @Test
    public void NagetiveTestOfLogin()throws InterruptedException{
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/");
        Thread.sleep(2000);

        WebElement LoginBtnLocation = driver.findElement(By.xpath("//input[@class='login-inp'][1]"));
        LoginBtnLocation.sendKeys("incorrect");

        WebElement passWordLocation = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passWordLocation.sendKeys("incorrect"+ Keys.ENTER);

        String expectResult = "Incorrect login or password";
        String actualResult = driver.findElement(By.cssSelector("div[class='errortext']")).getText();

        Assert.assertEquals(expectResult,actualResult);

    }

}
