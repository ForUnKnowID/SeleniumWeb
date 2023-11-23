package com.cydeo.tests.Day2_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cydeo.com");
        Thread.sleep(2000);
        // close current tab
        driver.close();


    }


}
