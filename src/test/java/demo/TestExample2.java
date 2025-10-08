package demo;

import demo.threadlocal.DriverManager;
import myproject.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class TestExample2 {

    @Test
    public void method1() {
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get("https://www.rediff.com");
        System.out.println("Title: " + driver.getTitle());
        DriverManager.getDriver().quit();
        DriverManager.remove();
    }


    @Test
    public void method2() {
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get("https://www.yahoo.com");
        System.out.println("Title: " + driver.getTitle());
        DriverManager.getDriver().quit();
        DriverManager.remove();
    }
}
