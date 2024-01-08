package com.cydeo.tests.Day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    //This class is used for starting and building reports
    ExtentReports reports;

    // this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this will define a test, enables adding logs,authors,test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setup(){
        // initialize the class
        reports = new ExtentReports();

        // create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        reports.attachReporter(htmlReporter);


        // title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        // Set environment information
        reports.setSystemInfo("Environment","QA");
        reports.setSystemInfo("OS",System.getProperty("os.name"));




    }

    @Test
    public void test1(){

        extentLogger = reports.createTest("TC123 Login as Driver Test");

        // test steps
        extentLogger.info("Open Chrome Browser");

        extentLogger.info("Go to This URL");

        extentLogger.info("Enter driver username password");

        extentLogger.info("Click Login");

        extentLogger.info("Verify Logged in");

        // pass() --> marks the test case as passed
        extentLogger.pass("TC123 is passed");


    }


    @AfterMethod
    public void tearDown(){
        // this is when the report is actually created
        reports.flush();

    }



}
