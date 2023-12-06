package com.cydeo.tests.Day10_actions_js;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Actions_js {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
    driver= WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();

    }


    @Test
    public void test1() throws InterruptedException {

        driver.get("https://practice.cydeo.com/hovers");
        WebElement img = driver.findElement(By.cssSelector("img"));
        // Action-> class that contains all the user instracturs
        // how to create actions objects --> passing driver as a constructor
        Actions actions = new Actions(driver);

        // perform method -> perform the action complete the action
        // moveToElement method - > move to your mouse to that WebElement (hover over)
        actions.moveToElement(img).perform();
        Thread.sleep(3000);


        WebElement viewLink = driver.findElement(By.xpath("(//div[@class='figure']/div/h5)[1]"));
        Assert.assertTrue(viewLink.isDisplayed(),"Varifying the viewLink is display");


    }


    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//div[@id='droptarget'][@class='k-header']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='draggable'][@data-role='draggable']"));

//        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();


        actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();

//        actions.dragAndDrop(source,target).perform();
//        Thread.sleep(2000);
        String a = driver.findElement(By.xpath("//div[@data-role='droptarget']")).getText();
        System.out.println(a);
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
