package com.cydeo.tests.Day9_popups_tabs_frames;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

@Test
public void test1(){
        driver.get("https://practice.cydeo.com/windows");
    System.out.println("Title before new window "+driver.getTitle());
    driver.findElement(By.linkText("Click Here")).click();
    System.out.println("Title after new window  = " + driver.getTitle());

    String currentWindowHandle = driver.getWindowHandle();
    Set<String> windowHandles = driver.getWindowHandles();

    for (String handle : windowHandles) {
        if (!handle.equals(currentWindowHandle)){
            driver.switchTo().window(handle);
        }

    }
}

@Test
public void moreThan2Window(){
    driver.get("https://practice.cydeo.com/windows");
    driver.findElement(By.linkText("Click Here")).click();
    System.out.println("Before Switch = " + driver.getTitle());
    Set<String> allWindow = driver.getWindowHandles();

    for (String s : allWindow) {
        driver.switchTo().window(s);
        if (s.equals("New Window")){
            break;
        }
    }

    System.out.println("driver.getTitle() = " + driver.getTitle());
}

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }

}
