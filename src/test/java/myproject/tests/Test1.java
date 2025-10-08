package myproject.tests;

import demo.threadlocal.DriverManager;
import org.testng.annotations.Test;

public class Test1 extends  BaseTest{
    @Test
    public void googleTest() {
        DriverManager.getDriver().get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @Test
    public void facebookTest() {
        DriverManager.getDriver().get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }
}
