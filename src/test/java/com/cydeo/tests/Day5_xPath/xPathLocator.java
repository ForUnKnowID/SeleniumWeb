package com.cydeo.tests.Day5_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class xPathLocator {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/multiple_buttons");
        Thread.sleep(3000);

        ArrayList<String> expectResultFromAsiyaNotMeIDontWannaDoItHudaHakki = new ArrayList<>();
        expectResultFromAsiyaNotMeIDontWannaDoItHudaHakki.add("Button 1");
        expectResultFromAsiyaNotMeIDontWannaDoItHudaHakki.add("Button 2");
        expectResultFromAsiyaNotMeIDontWannaDoItHudaHakki.add("Button 3");
        expectResultFromAsiyaNotMeIDontWannaDoItHudaHakki.add("Button 4");
        expectResultFromAsiyaNotMeIDontWannaDoItHudaHakki.add("Button 5");
        expectResultFromAsiyaNotMeIDontWannaDoItHudaHakki.add("Don't click!");

        WebElement actualResult = null;

        System.out.println("Test Start");
        for (int i = 1,j=0; i <=6 ; i++) {
            if (expectResultFromAsiyaNotMeIDontWannaDoItHudaHakki.get(j++).equals(driver.findElement(By.xpath("//button[@class='btn btn-primary']["+i+"]")).getText())){
                System.out.println("Go");
            }else {
                System.out.println("No");
            }

            driver.findElement(By.xpath("//div//button ["+i+"]")).click();
            System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
            System.out.println("Button Number "+i+" is Clicked");
            Thread.sleep(3000);
        }

        System.out.println("Test is done");

        driver.quit();

    }
}
