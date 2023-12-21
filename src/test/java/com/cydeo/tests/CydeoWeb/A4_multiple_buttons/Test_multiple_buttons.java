package com.cydeo.tests.CydeoWeb.A4_multiple_buttons;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test_multiple_buttons {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://practice.cydeo.com/multiple_buttons");
        System.out.println("Is The Title Match "+driver.getTitle().equals("Multiple Buttons"));

    }


    // Positive test making sure all the Buttons are clickable
    @Test
    public void Test1(){

        List<WebElement> allTheBtn = driver.findElements(By.xpath("//button"));

        for (int i = 1; i <= allTheBtn.size(); i++) {
            System.out.println(driver.findElement(By.xpath("//button["+i+"]")).getText());
            driver.findElement(By.xpath("//button["+i+"]")).click();


        }
    }

    //Making sure while click the buttons the messages are showing correctly
    @Test
    public void Test2(){

    }










    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }




}
