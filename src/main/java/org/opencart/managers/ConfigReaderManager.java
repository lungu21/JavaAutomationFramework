package org.opencart.managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderManager {
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    private static Properties definedProperties;

    private static void initDefineProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
            definedProperties = new Properties();
            definedProperties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String propertyKey) {
        if (definedProperties == null) {
            initDefineProperties();
            System.out.println("The properties was initialized");
        }
        return definedProperties.getProperty(propertyKey);
    }

}
