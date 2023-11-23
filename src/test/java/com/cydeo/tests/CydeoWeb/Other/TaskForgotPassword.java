package com.cydeo.tests.CydeoWeb.Other;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskForgotPassword {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com/forgot_password");
        System.out.println(driver.getCurrentUrl().equals("https://practice.cydeo.com/forgot_password"));
        System.out.println("The URL is correct");

        System.out.println("=================================");
        driver.navigate().to("https://practice.cydeo.com/forgot_password");
        System.out.println(driver.getTitle().equals("Forgot Password"));
        System.out.println("The Title is correct too");

        driver.close();
    }

}
