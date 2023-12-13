package com.cydeo.tests.Day8_types_of_elements_2.PersonTask;

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
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cydeo.com/dropdown");
        WebElement dorpDownElement = driver.findElement(By.id("state"));
        Select selectDropDown = new Select(dorpDownElement);
        List<WebElement> options = selectDropDown.getOptions();
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }


    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cydeo.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("state"));

        Select selectDropDown = new Select(dropDownElement);

        String expectionOption = "Select a State";
        String actualOption = selectDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectionOption,actualOption,"Verifying the first Select option");

        Thread.sleep(3000);
        selectDropDown.selectByVisibleText("Virginia");

        expectionOption = "Virginia";
        actualOption = selectDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectionOption,actualOption,"Verify first selection");
        Thread.sleep(3000);
        selectDropDown.selectByIndex(51);

        expectionOption = "Wyoming";
        actualOption = selectDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectionOption,actualOption,"Verify the Wyoming");



        Thread.sleep(3000);
        selectDropDown.selectByValue("TX");
        expectionOption = "Texas";
        actualOption=selectDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectionOption,actualOption,"Verify first selection");


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
