package com.cydeo.tests.CydeoVytruck.Page;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PTestBase {

   protected WebDriver driver;

   protected Actions actions;

   protected WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
    driver = Driver.getDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    actions = new Actions(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get(ConfigurationReader.getProperty("url"));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



}
