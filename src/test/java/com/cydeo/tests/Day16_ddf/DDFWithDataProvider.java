package com.cydeo.tests.Day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {


    @DataProvider
    public Object [][] testData(){

        String [][] data = {

                {"Person of Interest","10"},
                {"Sherlock","9"},
                {"Breaking Bad","9"},
                {"The Office","8"},
                {"Friends","7"},
                {"West World","10"},
                {"Gotham","9"},
                {"Dark","8"}
        };

        return  data;
    }


    @Test(dataProvider = "testData")
    public void test1(String tvShow, String rating){


        System.out.println("tvShow = " + tvShow+" Has rating "+rating);


    }


}
