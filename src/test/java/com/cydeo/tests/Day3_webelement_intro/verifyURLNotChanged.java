package com.cydeo.tests.Day3_webelement_intro;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class verifyURLNotChanged {
    public static void main(String[] args) {

       WebDriver driver =  WebDriverFactory.getDriver("chrome");
       driver.get("https://practice.cydeo.com/forgot_password");
       String url = driver.getCurrentUrl();
       driver.findElement(By.id("form_submit")).click();
//       if (url.equals("https://practice.cydeo.com/forgot_password")){
//            System.out.println("There are equal");
//       }else {
//            System.out.println("There are not");
//       }
        String actualUrl = driver.getCurrentUrl();

        System.out.println(url.equals(actualUrl));
       driver.close();






    }
}
