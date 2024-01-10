package com.cydeo.tests.CydeoWeb.A7_Drag_And_Drop;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropAndDropTest {

    protected WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/drag_and_drop");

    }



    // Move to A To B
    @Test
    public void test1() throws InterruptedException {
        Actions actions = new Actions(driver);

        // Locate the A locator with Text
        String ALocationText = driver.findElement(By.xpath("(//header)[1]")).getText();
        // print out
        System.out.println("ALocationText = " + ALocationText);
        // locate the A
        WebElement Aelement = driver.findElement(By.id("column-a"));
        // locate the B
        WebElement BElement = driver.findElement(By.id("column-b"));
        // Move A to B location
        actions.moveToElement(Aelement).clickAndHold().moveToElement(BElement).release().perform();
        Thread.sleep(2000);

        // checking the after change with header text
        ALocationText = driver.findElement(By.xpath("(//header)[1]")).getText();
        System.out.println("ALocationText = " + ALocationText);


    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }




}
