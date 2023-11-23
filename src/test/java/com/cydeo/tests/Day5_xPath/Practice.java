package com.cydeo.tests.Day5_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/multiple_buttons");
        WebElement singleEleliment = driver.findElement(By.xpath("//body//div//div//div//div//button[1]"));

        ArrayList<WebElement> list = new ArrayList<>();


        for (int i = 1; i < 7 ; i++) {
            System.out.println(driver.findElement(By.xpath(("//body//div//div//div//div//button[" + i + "]"))).getText());
        }



    }
}
