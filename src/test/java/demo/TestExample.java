package demo;

import demo.threadlocal.DriverManager;
import myproject.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestExample {

    @BeforeMethod
    public void setup() {
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        DriverManager.setDriver(driver);
    }

    @Test
    public void method1() {
        DriverManager.getDriver().get("https://www.google.com");
        System.out.println("Title: " + DriverManager.getDriver().getTitle());
    }

    @Test
    public void method2() {
        DriverManager.getDriver().get("https://www.facebook.com");
        System.out.println("Title: " + DriverManager.getDriver().getTitle());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.getDriver().quit();
        DriverManager.remove();
    }
}


