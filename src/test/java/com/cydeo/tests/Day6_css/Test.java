package com.cydeo.tests.Day6_css;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        WebElement inputBoxLocation = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        inputBoxLocation.sendKeys("selenium");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Thread.sleep(2000);
        String expectResult = "\"selenium\"";

        WebElement textLocator = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualResult = textLocator.getText();

        if (expectResult.equals(actualResult)){
            System.out.println("There are equal");
        }else {
            System.out.println("actualResult = " + actualResult+" "+"expectResult = " + expectResult);

        }

        driver.close();

    }
}
