package basics.RuntimePolyMorphism;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public interface DriverManagerNew {
    public WebDriver getDriver(); // This method doesn't need BrowserType as an argument anymore
}

 enum BrowserType {
    CHROME,
    FIREFOX
}

 class ChromeDriverManager implements DriverManagerNew {
    @Override
    public WebDriver getDriver() {
        // Code to initialize and return ChromeDriver
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        return new ChromeDriver();
    }
}

 class FirefoxDriverManager implements DriverManagerNew {
    @Override
    public WebDriver getDriver() {
        // Code to initialize and return FirefoxDriver
        // System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
        return new FirefoxDriver();
    }
}


 class DriverManagerFactory {
    public static DriverManagerNew getManager(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                return new ChromeDriverManager();
            case FIREFOX:
                return new FirefoxDriverManager();
            default:
                throw new UnsupportedOperationException("Unsupported browser type: " + browserType);
        }
    }
}


 class TestSetup {
    public void setup(String browser) {
        // Get browser type from a configuration or test parameter
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());

        // Get the correct driver manager from the factory
        DriverManagerNew manager = DriverManagerFactory.getManager(browserType);

        // Get the driver and use it in your tests
        WebDriver driver = manager.getDriver();
        driver.get("https://google.com");
    }
}