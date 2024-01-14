package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{


//    @FindBy(xpath = )
//    public WebElement  email;

    public WebElement getContactEmail(String email){

        String xpath = "//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.getDriver().findElement(By.xpath(xpath));


    }


}
