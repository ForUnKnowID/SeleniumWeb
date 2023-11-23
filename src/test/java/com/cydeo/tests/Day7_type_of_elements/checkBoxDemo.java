package com.cydeo.tests.Day7_type_of_elements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class checkBoxDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.cssSelector("input[name='checkbox1'"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("input[name='checkbox2'"));
        // the checkbox is selected
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        Thread.sleep(3000);
        driver.quit();

    }

}
