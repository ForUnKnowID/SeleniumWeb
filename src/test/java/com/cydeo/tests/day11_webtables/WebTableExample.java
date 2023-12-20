package com.cydeo.tests.day11_webtables;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/tables");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void getAllHeaders(){
        // how many columns we have ?
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("allHeaders.size() = " + allHeaders.size());
        for (WebElement each : allHeaders) {
            System.out.println(each.getText()+" ");
        }


    }

    @Test
    public void printTableSize(){
        // how many columns we have ?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("allRows.size() = " + headers.size());


        // numbers of raws
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("elements.size() = " + allRowsWithHeader.size());


        // number of rows without header (we perfer this)

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());


    }

    @Test
    public void getRow(){
        //print the second row information
       WebElement row3 =  driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]"));
       System.out.println("row2.getText() = " + row3.getText());
    }

    @Test
    public void getRows (){
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= allRows.size(); i++) {
           String eachText =  driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]")).getText();
           System.out.println("eachText = " + eachText);

           // loop shortcut iter and itar


        }


    }

    @Test
    public void getAllCellInOneRow(){

        List <WebElement> allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement eachCell : allCellInOneRow) {
            System.out.print(eachCell.getText()+" ");
        }
    }

    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println(singleCell.getText());
        
    }
    
    @Test
    public void printAllCellByIndex(){

        int rowNumber  = getNumberOfRows();
        System.out.println("rowNumber = " + rowNumber);
        int colNumber = getNumberOfColumns();
        System.out.println("colNumber = " + colNumber);

        for (int i = 1; i <=getNumberOfRows(); i++) {

            for (int j = 0; j <= colNumber; j++) {

                String cellXpath  = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXpath);

            }


        }


    }

    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }
    private int getNumberOfRows() {
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        return allRowsWithHeader.size();
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String firstName = "Jason";
        String xpath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        WebElement email  = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }




}
