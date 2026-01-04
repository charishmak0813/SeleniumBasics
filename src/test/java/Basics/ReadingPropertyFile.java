package Basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fprop = new FileInputStream(System.getProperty("user.dir")+"/testData/config.properties");
        Properties prop = new Properties();
        prop.load(fprop);
        String appurl = prop.getProperty("appurl");
        Set<String> keys = prop.stringPropertyNames();
        Set<Object> keys1 = prop.keySet();
        System.out.println("Keys: " + keys);
        Collection<Object> values = prop.values();
        System.out.println("Values: " + values);
       fprop.close();
    }
}
