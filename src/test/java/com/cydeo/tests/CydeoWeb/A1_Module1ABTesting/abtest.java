package com.cydeo.tests.CydeoWeb.A1_Module1ABTesting;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class abtest {

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    // Locate All The Web Elements and get there names
    @Test
    public void locateWebElement(){
        driver.get("https://practice.cydeo.com/abtest");

        // Test The Title
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"The Tittle is wrong");

        // Test the URL
        String expectedURL = "https://practice.cydeo.com/abtest";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL,"The URL is wrong");

        //Check how many web elements are and what are the names
        List<WebElement> allTheLink = driver.findElements(By.xpath("//a"));
        System.out.println("There are "+allTheLink.size()+" Web Element found");
        for (WebElement eachElement : allTheLink) {
            System.out.println(eachElement.getText());
        }









    }


    //Does Home BTN Clickable
    @Test
    public void homeBtn(){
        driver.get("https://practice.cydeo.com/abtest");
        //Xpath -   a[text()='Home']
        //Xpath - a[@class='nav-link']
        // CSS  - li a
        // Xpath - a[contains(text(),'Home')]
        WebElement homeBtnLocation =driver.findElement(By.xpath("//a[text()='Home']"));
        // Making sure the Home Btn showing on the page
        Assert.assertTrue(homeBtnLocation.isDisplayed(),"The Home");
        homeBtnLocation.click();





    }


    @Test
    public void cydeoBtn(){
        driver.get("https://practice.cydeo.com/abtest");
        // xpath - //a[text()='CYDEO']
        // xpath - //a[@target='_blank']
        //xpath - a[contains(text(),'CYDEO')]
        // CSS - div a
        WebElement cydeoBtn = driver.findElement(By.xpath("//a[@target='_blank']"));
        cydeoBtn.click();


        // Making sure the Cydeo button is display
        Assert.assertTrue(cydeoBtn.isDisplayed());
        String expectingResult = "CYDEO";
        String actualResult = driver.findElement(By.xpath("        //a[@target='_blank']\n")).getText();
        Assert.assertEquals(expectingResult,actualResult,"The Cydeo Btn has problem");
    }


    @Test
    public void WebText(){
        driver.get("https://practice.cydeo.com/abtest");
        // CSS - div h3
        // Xpath - //h3
        // Xpath - //h3[text()='No A/B Test']

        // The No A B Test text is display
        WebElement NoAbTest = driver.findElement(By.cssSelector("div h3"));
        Assert.assertTrue(NoAbTest.isDisplayed(),"No AB Test is showing");
        String actualRe = NoAbTest.getText();
        String expectedRe = "No A/B Test";

        // The two are matching
        Assert.assertEquals(expectedRe,actualRe,"The Text is wrong");

        // Making sure that the text is should not clickable




    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
