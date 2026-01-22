package com.utility;

import com.constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    //read propertie file
    public static String readProperties(Env env, String PropertieName)  {
        File proFile = new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
        FileReader fileReader = null;
        Properties properties = new Properties();
        try {
            fileReader = new FileReader(proFile);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value = properties.getProperty(PropertieName);
        return value;
    }
}


