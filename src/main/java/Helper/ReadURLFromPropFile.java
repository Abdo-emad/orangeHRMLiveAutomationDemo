package Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadURLFromPropFile {
    public static String ReadURLFromFile(String Key) throws IOException {
        String path = System.getProperty("user.dir")+"//src//main//java//Utilities//get.properties";
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            Properties properties =new Properties();
            properties.load(fileInputStream);
          return  properties.getProperty(Key);
        }

    }
}
