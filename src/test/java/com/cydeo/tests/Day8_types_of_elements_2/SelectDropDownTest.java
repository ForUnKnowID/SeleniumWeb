package com.cydeo.tests.Day8_types_of_elements_2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }



    @Test
    public void test1(){

        driver.get("https://practice.cydeo.com/dropdown");

        WebElement dropDoenBtn = driver.findElement(By.id("state"));

        Select select = new Select(dropDoenBtn);
        List<WebElement> options = select.getOptions();
        System.out.println(options.size());

        for (WebElement option : options) {
            if (option.getText().equals("Florida")){
                option.click();
                System.out.println(option.getText());
            }else {

            }
        }


    }

    @Test
    public void test2()throws InterruptedException{
        driver.get("https://practice.cydeo.com/dropdown");

        WebElement dropDoenBtn = driver.findElement(By.id("state"));

        Select select = new Select(dropDoenBtn);

        String expectedOption = "Select a State";
        String actuaOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actuaOption,"Verify forst select");

        // how to select Options from dropdown
        // 1. Select using visible text

        Thread.sleep(3000);
        select.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actuaOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actuaOption,expectedOption,"verify first selection");

        // 2 SELECT USING INDEX
        Thread.sleep(5000);
        select.selectByIndex(51);

        expectedOption = "Wyoming";
        actuaOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actuaOption,expectedOption,"verify first selection");

        // 3 SELECT BY VALUE
        Thread.sleep(3000);
        select.selectByValue("TX");
        expectedOption = "Texas";
        actuaOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actuaOption,expectedOption,"verify first selection");


    }



    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();

    }




}
