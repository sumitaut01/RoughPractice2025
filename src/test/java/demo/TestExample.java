package demo;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;

public class TestExample {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
