package myproject.tests;

import org.testng.annotations.Test;

public class Test1 extends  BaseTest{
    @Test
    public void googleTest() {
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @Test
    public void facebookTest() {
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }
}
