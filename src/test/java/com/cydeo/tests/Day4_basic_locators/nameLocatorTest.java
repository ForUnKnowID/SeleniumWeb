package com.cydeo.tests.Day4_basic_locators;

import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException{

        Faker faker = new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        // going to current url
        driver.get("https://practice.cydeo.com/sign_up");

        Thread.sleep(3000);
        // Finding the fullname input box locator By name
        WebElement fullnameInputBox = driver.findElement(By.name("full_name"));

        // giving some info using faker
        fullnameInputBox.sendKeys(faker.name().name());

        // finding the email input box by name
        WebElement emailInputBox = driver.findElement(By.name("email"));

        // giving a random gmail using faker
        emailInputBox.sendKeys(faker.name().firstName()+"@gmail.com");

        // finding the sign up btm
        WebElement signUpBtm = driver.findElement(By.name("wooden_spoon"));

        // click it
        signUpBtm.click();

        driver.close();









    }
}
