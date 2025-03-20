package org.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static String readJsonPath() {
        Properties properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar el archivo config.properties");
                return null;
            }
            properties.load(input);
            return properties.getProperty("json.path"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

