package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage {


    @FindBy(xpath = "//div[@class='pull-left']/h1")
    public WebElement fullName;

    @FindBy(css = "a.phone")
    public WebElement phone;
    @FindBy(css = "a.email")
    public WebElement email;






}
