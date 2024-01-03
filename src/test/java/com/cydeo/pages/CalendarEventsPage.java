package com.cydeo.pages;


import com.cydeo.tests.Day12_properties_Tests.TestBase;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends TestBase {
    public CalendarEventsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;
}
