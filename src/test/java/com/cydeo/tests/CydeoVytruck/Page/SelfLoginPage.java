package com.cydeo.tests.CydeoVytruck.Page;

import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class SelfLoginPage extends PTestBase{


    @FindBy(id = "prependedInput")
    WebElement userNameLocation;

    @FindBy(id = "prependedInput2")
    WebElement passwordLocation;

    @FindBy(id = "remember_me")
    WebElement RememberMeOnThisComputer;

    @FindBy(xpath = "(//a)[1]")
    WebElement ForgotYourPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement LogInBtn;






}
