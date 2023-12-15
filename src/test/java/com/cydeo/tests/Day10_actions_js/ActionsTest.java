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

import java.util.List;

public class ActionsTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }



    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cydeo.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions --> class that contains all the user interactions
        // how to create actions objet --> passing driver as a constructor
        Actions actions = new Actions(driver);

        Thread.sleep(2000);

        // Perform() --> move your mouse to webElement (hover over)
        // MoveToElement --> move your mouse to webelement (hover over)
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewLink.isDisplayed(),"Verify the viewLink is displayed or not");



    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.xpath("//div[@id='draggable'][@data-role='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droptarget'][@class='k-header']"));
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();
        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();

    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.xpath("//div[@id='draggable'][@data-role='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droptarget'][@class='k-header']"));
        Actions actions = new Actions(driver);
        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(1000);

        if (acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if (acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }


        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

        Thread.sleep(3000);

        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

        String text = driver.findElement(By.xpath("//div[contains(text(),'You did great!')]")).getText();

        Assert.assertTrue(text.equals("You did great!"));

    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
