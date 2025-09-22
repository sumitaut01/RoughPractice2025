package myproject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class AwsSeleniumTest {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(
            new URL("http://3.229.28.53:4444/wd/hub"),
            options
        );

        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}


///ui → for humans (dashboard).
//
//        /wd/hub → for Selenium clients (your test code).
//
//        / → base endpoint.