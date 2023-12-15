package com.cydeo.tests.Day10_file_upload;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Path {


    @Test
    public void test1(){
        // Absulote Path = /Users/bilal/IdeaProjects/SeleniumWeb/src/test/java/com/cydeo/tests/Day10_file_upload/Path.java
       // System.out.println(System.getProperty("user.dir"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/java/com/cydeo/tests/Day10_file_upload/Path.java";

        String actualPath = "/Users/bilal/IdeaProjects/SeleniumWeb/src/test/java/com/cydeo/tests/Day10_file_upload/Path.java";
        String fullPath = projectPath+"/"+filePath;
        System.out.println(fullPath);

        Assert.assertEquals(actualPath,fullPath);
    }


}
