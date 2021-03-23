package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
/*

    public static void main(String[] args) throws IOException {

        // 1. create object of properties file
        Properties prop = new Properties();

        // 2 . read the file
        FileInputStream fis = new FileInputStream("config.properties");

        // 3. load the properties object with file object:
        prop.load(fis);

        // 4. read the value of the key
        System.out.println(prop.getProperty("url"));

        System.out.println(prop.getProperty("username"));

    }
*/
            static Properties getLoadedPropertiesObject() throws IOException {

                // 1. create object of properties file
                Properties prop = new Properties();

                // 2 . read the file
                FileInputStream fis = new FileInputStream("Config\\config.properties");

                // 3. load the properties object with file object:
                prop.load(fis);

                return prop;
            }


            public static String getUrl() throws IOException {

                return getLoadedPropertiesObject().getProperty("url");
            }

          /*  public static String getUserName() throws IOException {
                return  getLoadedPropertiesObject().getProperty("username");
            }

            public static String getPassword() throws IOException {
                return  getLoadedPropertiesObject().getProperty("password");
            }
*/

}
