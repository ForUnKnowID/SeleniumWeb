package com.cydeo.pages;

import org.testng.annotations.Test;

public class DashboardPage extends BasePage{


    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
    }
}
