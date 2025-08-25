package demo;

import enums.EnvEnum;
import enums.RunMode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class R_XEnum {
    public static void main(String[] args) throws IOException {

        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream("src/test/resources/sample.properties");
        properties.load(fileInputStream);


        //From enum directly
        EnvEnum env= EnvEnum.UAT;
        switch (env){
            case QA, UAT -> System.out.println(env.getFullName());//User Acceptance Testing
        }
        //From Valueof
        RunMode runEnv= RunMode.valueOf(properties.getProperty("runmode").toString().toUpperCase());


    }
}
