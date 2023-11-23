package com.cydeo.tests.CydeoWeb.Other;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class S {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/abtest");
        List<WebElement> aAll = driver.findElements(By.xpath("//a"));
        System.out.println("aAll.size() = " + aAll.size());

        for (WebElement a : aAll) {
            System.out.println("a = " + a.getText());
        }
    }

}
