package com.cydeo.tests.Day7_type_of_elements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/radio_buttons");
        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn = driver.findElement(By.cssSelector("#red"));
        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected() = " + redRadioBtn.isSelected());

        Assert.assertTrue(blueRadioBtn.isSelected(),"The Blue Button is selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"The red button is not selected");
        redRadioBtn.click();

        Assert.assertTrue(redRadioBtn.isSelected(),"The red btn is selected");
        Assert.assertFalse(blueRadioBtn.isSelected(),"The blue btn is not selected");


    }



}
