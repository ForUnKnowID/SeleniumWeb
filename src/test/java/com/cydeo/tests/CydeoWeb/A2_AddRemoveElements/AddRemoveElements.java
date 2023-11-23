package com.cydeo.tests.CydeoWeb.A2_AddRemoveElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElements {

    WebDriver driver;




    // set up chrome
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void clickAdd(){
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        //Xpath - //div//h3
        //Xpath - //button[@onclick='addElement()']
        // CSS - div button
        // Xpath = //*[text()='Add Element']
        WebElement addElement = driver.findElement(By.cssSelector("div button"));
        // click 5 times "Add Element" button
        for (int i = 1; i <=5 ; i++) {
            addElement.click();
        }


        // CSS - #elements:nth-of-type(1)

        //shows how many add element showed
        List<WebElement> allElements = driver.findElements(By.xpath("//button[@class='added-manually']"));
        for (int i = 0; i < allElements.size(); i++) {
            System.out.println(addElement.getText()+" "+i);
        }

        System.out.println("Click Add Button is Done ");

    }

    @Test
    public void ClickDeleteBtn() throws InterruptedException{
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        // Locators
        //Xpath - //div//h3
        //Xpath - //button[@onclick='addElement()']
        // CSS - div button
        // Xpath = //*[text()='Add Element']

        // click 5 times "Add Element" button
        WebElement AddElementBtnLocation  = driver.findElement(By.cssSelector("div button"));
        int count =0;
        int actualClickCount = 5;
        for (int i =1; i<=5;i++){
            AddElementBtnLocation.click();
            count++;
            System.out.println("AddElementBtnLocation.isDisplayed() = " + AddElementBtnLocation.isDisplayed());
        }
        // make sure it clicks 5 times
        Assert.assertEquals(count,actualClickCount,"Didn't click 5 times, it is more or less");

        Thread.sleep(3000);
        // Able to delete the button of the page
        List<WebElement> allDeletedElement = driver.findElements(By.xpath("//button[@class='added-manually']"));
        int expectedDeleteCount = 0;
        int actualDeleteCount = 5;
        for (WebElement eachDeleteBtn : allDeletedElement) {
            eachDeleteBtn.click();
            System.out.println("Delete Button has Click "+actualDeleteCount--);
        }
        Assert.assertEquals(expectedDeleteCount,actualDeleteCount,"The delete button is more or less");


        System.out.println("Click Delete Button is Test Done");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
