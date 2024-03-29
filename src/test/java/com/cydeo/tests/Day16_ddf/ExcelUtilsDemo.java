package com.cydeo.tests.Day16_ddf;

import com.cydeo.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        // Create an object from ExcelTil
        // it accepts two argument
        // Argument 1Location of the file(path)
        // Argument 2: Sheet that wew want to open (sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/ressources/Vytracktestdata.xlsx","QA3-short");

        // how many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        // How many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        // get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        // get all data in list of maps
        List<Map<String, String>> dataList =  qa3short.getDataList() ;
        for (Map<String,String> onerow : dataList){
            System.out.println(onerow);
        }

        // get Nana as a value
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname"));
        System.out.println("dataList.get(8).get(\"lastname\") = " + dataList.get(8).get("lastname"));


        // get all data in 2d array
        String [][] dataArray = qa3short.getDataArray();

        // print 2d array
        System.out.println(Arrays.deepToString(dataArray));
    }

}
