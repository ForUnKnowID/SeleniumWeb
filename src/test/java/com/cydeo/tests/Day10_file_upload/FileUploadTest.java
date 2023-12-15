package com.cydeo.tests.Day10_file_upload;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

}
