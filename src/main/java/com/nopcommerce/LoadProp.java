package com.nopcommerce;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//load properties class for getting data from config file
public class LoadProp {
    static Properties prop;
    static FileInputStream input;
    static String filename = "testconfig.properties";
    static String fileLocation = "src/test/Resources/TestData/";

    public String getProperty(String key) {
        prop = new Properties();
        try {
            input = new FileInputStream(fileLocation + filename);
            prop.load(input);
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}