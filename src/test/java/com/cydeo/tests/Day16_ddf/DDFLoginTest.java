package com.cydeo.tests.Day16_ddf;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.tests.Day12_properties_Tests.TestBase;
import com.cydeo.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){

        ExcelUtil qa3short = new ExcelUtil("src/test/reources/Vytracktestdata.xlsx","QA3-short");

        String [][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void test1(String userName,String password,String firstName,String lastName){
        extentLogger = reports.createTest("Test "+firstName);

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstName+" "+lastName;
        Assert.assertEquals(actualFullName,expectedFullName,"Verify the Full names are match");


    }

}
