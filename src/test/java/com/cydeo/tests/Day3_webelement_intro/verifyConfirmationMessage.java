package com.cydeo.tests.Day3_webelement_intro;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException{


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://practice.cydeo.com/forgot_password");

        String beforeUrl = driver.getCurrentUrl();

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("Ab@gmail.com");

        Thread.sleep(2000);

        WebElement RetrievePasswordBtn = driver.findElement(By.id("form_submit"));
        RetrievePasswordBtn.click();

        Thread.sleep(2000);

        WebElement message = driver.findElement(By.id("content"));
        boolean a = message.getText().equals("Your e-mail's been sent!");

        System.out.println(a);
        driver.close();

        // what is getAttribute method?



    }
}
