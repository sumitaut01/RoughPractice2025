package zzRough;

import org.apache.http.io.SessionOutputBuffer;

public class RoughTemp extends Test implements  D1,D2 {


    public static void main(String[] args) {

        System.out.println("--From Abstract Class Reference");
        Test test = new RoughTemp();
        test.myMethod();
        //--From Abstract Class Reference
        //abstract implemented


        System.out.println("--From Implementing Class Reference");
        RoughTemp roughTemp = new RoughTemp();
        roughTemp.myMethod();
        //--From Implementing Class Reference
        //abstract implemented


        System.out.println("--Using Enum");
        String browser = "chrome";
        BrowserType browserValue = BrowserType.valueOf(browser.toString().toUpperCase());

        switch (browserValue) {
            case CHROME -> System.out.println("chome");
            case MOZILLA -> System.out.println("moziila");
            default -> System.out.println("Unknown browser");
        }


        System.out.println("--Using Enum Constructor Style");
        String env = "qa";
        ENV envValue = ENV.valueOf(env.toString().toUpperCase());

        switch (envValue) {
            case QA,UAT -> System.out.println(envValue.geturl() + " "+envValue.geturl());
            default -> System.out.println("Unknown ");
        }


        // Method implemented:
        roughTemp.m1(); //from class
        D1 d1=new RoughTemp();//D1 reference
        D2 d2=new RoughTemp();//D2 reference

    }

    @Override
    void myMethod() {
        System.out.println("abstract implemented");
    }

    @Override
    public void m1() {
        System.out.println("m1 implemented");
    }
}


abstract class Test {
    abstract void myMethod();
}


enum BrowserType {
    CHROME,
    MOZILLA;
}


enum ENV {

    QA("http://qa.someurl", "qadburl"),
    UAT("http://uat.someurl", "uatdburl");
    private String url;
    private String dburl;

    private ENV(String url, String dburl) {
        this.url = url;
        this.dburl = dburl;
    }


    public String getDburl() {
        return dburl;
    }

    public String geturl() {
        return url;
    }
}


interface  D1{

    void m1();
}


interface D2{

    void m1();
}