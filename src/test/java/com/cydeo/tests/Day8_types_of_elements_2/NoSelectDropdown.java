package com.cydeo.tests.Day8_types_of_elements_2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));
        dropdownElement.click();
        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));
        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());

        for (WebElement element : dropdownOptions) {
            System.out.println(element.getText());
        }

        dropdownOptions.get(2).click();



    }



}
