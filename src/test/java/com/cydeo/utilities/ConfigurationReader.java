package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            // what file to read
            String path="configuration.properties";

            // read the file into Java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);

            //properties --> class that store properties in key / value format
            properties = new Properties();

            // the value from the file input is loaded fed in the properties object
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static String getProperty(String keyName){
        return properties.getProperty(keyName);
    }



}
