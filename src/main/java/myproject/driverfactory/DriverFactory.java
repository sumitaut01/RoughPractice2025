package myproject.driverfactory;

import myproject.enums.BrowserType;
import myproject.enums.RemoteProvider;
import myproject.enums.RunMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import myproject.utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver() throws MalformedURLException {
        RunMode runMode = RunMode.valueOf(ConfigReader.get("runmode").toUpperCase());
        BrowserType browser = BrowserType.valueOf(ConfigReader.get("browser").toUpperCase());

        if (runMode == RunMode.LOCAL) {
            driver = getLocalDriver(browser);
        } else if (runMode == RunMode.REMOTE) {
            RemoteProvider provider = RemoteProvider.valueOf(ConfigReader.get("remoteprovider").toUpperCase());
            driver = getRemoteDriver(browser, provider);
        }
        return driver;
    }

    private static WebDriver getLocalDriver(BrowserType browser) {
        switch (browser) {
            case CHROME:
                return new ChromeDriver(new ChromeOptions());
            case FIREFOX:
                return new FirefoxDriver(new FirefoxOptions());
            default:
                throw new IllegalArgumentException("Invalid local browser: " + browser);
        }
    }

    private static WebDriver getRemoteDriver(BrowserType browser, RemoteProvider provider) throws MalformedURLException {
        String gridUrl;
        switch (provider) {
            case AWS:
                gridUrl = ConfigReader.get("gridUrlaws");
                break;
            case AZURE:
                gridUrl = ConfigReader.get("gridUrlazure");
                break;
            case GITHUB:
                gridUrl = ConfigReader.get("gridUrlgithub");
                break;
            default:
                throw new IllegalArgumentException("Unknown provider: " + provider);
        }

        switch (browser) {
            case CHROME:
                return new RemoteWebDriver(new URL(gridUrl), new ChromeOptions());
            case FIREFOX:
                return new RemoteWebDriver(new URL(gridUrl), new FirefoxOptions());
            default:
                throw new IllegalArgumentException("Invalid remote browser: " + browser);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
