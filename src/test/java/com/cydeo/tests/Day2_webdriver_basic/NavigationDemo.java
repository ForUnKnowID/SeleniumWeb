package com.cydeo.tests.Day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        // navigate().back();    navigate().forward();    navigate().refresh();

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        driver.navigate().to("https://www.youtube.com/");

        Thread.sleep(3000);

        driver.navigate().back();
    }
}
