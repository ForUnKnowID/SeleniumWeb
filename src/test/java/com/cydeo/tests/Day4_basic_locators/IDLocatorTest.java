package com.cydeo.tests.Day4_basic_locators;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {

    public static void main(String[] args) throws  InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://practice.cydeo.com/multiple_buttons");
        Thread.sleep(3000);
        WebElement dontClickBtn = driver.findElement(By.name("button6"));
        dontClickBtn.click();
        Thread.sleep(3000);
        String expectedText = "Now it's gone!";
        String ActualResult = driver.findElement(By.id("result")).getText();
        if (expectedText.equals(ActualResult)){
            System.out.println("There are the same");
        }else {
            System.out.println("There are not ");
        }

        driver.close();



    }
}
