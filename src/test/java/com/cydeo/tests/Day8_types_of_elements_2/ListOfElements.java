package com.cydeo.tests.Day8_types_of_elements_2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

WebDriver driver;

    @BeforeMethod
    public void setUp(){
         driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void test1(){

        driver.get("https://practice.cydeo.com/multiple_buttons");

        List<WebElement> button = driver.findElements(By.tagName("button"));

        System.out.println("button.size() = " + button.size());

        Assert.assertEquals(button.size(),6,"the size are 6");

        // iter
        for (WebElement webElement : button) {
            // System.out.println("webElement.getText() = " + webElement.getText());
            System.out.println(webElement.isDisplayed());
            Assert.assertTrue(webElement.isDisplayed(),"verify buttons are displayed");
        }

        // click second button
        button.get(1).click();


    }

    @Test
    public void test2(){
        driver.get("https://practice.cydeo.com/multiple_buttons");
        driver.manage().window().maximize();

        List<WebElement> buttons = driver.findElements(By.tagName("buttonibivivi"));
        System.out.println(buttons.size());
    }


    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();

    }


}
