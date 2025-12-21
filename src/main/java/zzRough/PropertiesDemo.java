package zzRough;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {


    @Test
    public void properties() throws IOException {
        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(new File("src/test/resources/sample.properties"));
        properties.load(fileInputStream);
        System.out.println(properties.getProperty("env"));
        System.out.println(properties.setProperty("env","qa"));
        System.out.println(properties.setProperty("newprop","newpropvalue"));
        System.out.println(properties);

    }

    @Test
    public void enumsDemo() throws IOException {




    }
}

enum week{
   FIRST,
    SECOND;
}