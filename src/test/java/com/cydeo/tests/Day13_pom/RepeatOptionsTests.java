package com.cydeo.tests.Day13_pom;

import com.cydeo.pages.CalendarEventsPage;
import com.cydeo.pages.CreateCalendarEventsPage;
import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.tests.Day12_properties_Tests.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepeatOptionsTests extends TestBase {

    @Test
    public void test1(){
        LoginPage login = new LoginPage();
        login.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage calendarEventsPage1 = new CreateCalendarEventsPage();
        calendarEventsPage1.repeat.click();

        Assert.assertTrue(calendarEventsPage1.days.isSelected(),"Verify repeat is selected");
        Assert.assertFalse(calendarEventsPage1.weekday.isSelected(),"Verify the weekday is not selected");




    }




}
