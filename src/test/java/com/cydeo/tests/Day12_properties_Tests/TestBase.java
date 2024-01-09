package com.cydeo.tests.Day12_properties_Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import freemarker.template.SimpleDate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {

   protected WebDriver driver;
   protected Actions actions;
   protected WebDriverWait wait;
    //This class is used for starting and building reports
    protected ExtentReports reports;

    // this class is used to create HTML report file
   protected ExtentHtmlReporter htmlReporter;

    //this will define a test, enables adding logs,authors,test steps
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){

        // initialize the class
        reports = new ExtentReports();

        // create a report path
        String projectPath = System.getProperty("user.dir");
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = projectPath+"/test-output/report"+date+" .html";

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

    @AfterMethod
    public void tearDownTest(){
        // this is when the report is actually created
        reports.flush();
    }

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(ConfigurationReader.getProperty("url"));
    }

    //ITestResult class describes the result of a test in TestNG
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        // if test fails
        if (result.getStatus()==ITestResult.FAILURE){

            // record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location into new List String
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            // add your screenshot to your report
            extentLogger.addScreenCaptureFromBase64String(screenShotPath);

            // capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());


        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }


}
