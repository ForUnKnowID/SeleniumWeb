package com.cydeo.tests.Day13_pom;

import com.cydeo.pages.CalendarEventsPage;
import com.cydeo.pages.CreateCalendarEventsPage;
import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.tests.Day12_properties_Tests.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {


    @Test
    public void test1(){

            LoginPage login = new LoginPage();

            login.loginAsDriver();

            String expectedSubTitle = "Quick Launchpad";

            DashboardPage  dashboardPage = new DashboardPage();

            String actualSubtitle = dashboardPage.getPageSubTitle();

            Assert.assertEquals(actualSubtitle,expectedSubTitle,"verity Subtitle");

            dashboardPage.navigateToModule("Activities","Calendar Events");

            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    }
}
