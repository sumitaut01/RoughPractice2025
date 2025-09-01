package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class RemoteChromeOptionsExample {

    public static void main(String[] args) throws Exception {

        // 1. Configure the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Example: run in headless mode
        options.addArguments("--window-size=1920,1080"); // Example: set window size

        // 2. Set the URL of the Selenium Grid Hub
        URL hubUrl = new URL("http://localhost:4444/");

        // 3. Instantiate RemoteWebDriver with the Hub URL and ChromeOptions
        WebDriver driver = new RemoteWebDriver(hubUrl, options);

        try {
            driver.get("https://www.google.com");
            System.out.println("Page title is: " + driver.getTitle());
            
        } finally {
            // Always quit the driver to release resources on the Node
            if (driver != null) {
                driver.quit();
            }
        }
    }
}