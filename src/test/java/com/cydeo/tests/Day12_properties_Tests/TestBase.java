package com.cydeo.tests.Day12_properties_Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
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

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }


}
