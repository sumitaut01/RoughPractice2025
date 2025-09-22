package demo;

import myproject.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestExample {

    @Test
    public void method1() {
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }


    @Test
    public void method2() {
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.get("https://www.facebook.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
