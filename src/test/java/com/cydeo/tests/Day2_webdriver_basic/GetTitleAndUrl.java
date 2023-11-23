package com.cydeo.tests.Day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {

        // navigate() , getTitle();,getCurrentUrl();



        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://practice.cydeo.com");

        String title = driver.getTitle();

        System.out.println("title = " + title);

        String currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

    }
}
