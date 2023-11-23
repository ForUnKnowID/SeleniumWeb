package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {



    public static WebDriver getDriver (String browserType){

        WebDriver driver = null;
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
                 break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.err.println("Invalid Browser");
                System.exit(1);
        }


        return driver;
    }

}
