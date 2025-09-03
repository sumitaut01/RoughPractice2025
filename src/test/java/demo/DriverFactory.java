package demo;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.EnumMap;
import java.util.function.Supplier;

//Why EnumMap is Great Here
//Type Safety → only valid BrowserType keys allowed.
//Performance → faster than HashMap because lookup is array-based.
//Order → drivers stored in the order enums are declared (not random).
//Cleaner than Switch → no giant switch (browserType) needed.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.EnumMap;
import java.util.function.Supplier;

public class DriverFactory {

    private static final EnumMap<BrowserType, Supplier<WebDriver>> drivers =
            new EnumMap<>(BrowserType.class);

    static {
        // ✅ Chrome with safe options for CI
        drivers.put(BrowserType.CHROME, () -> {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());
            return new ChromeDriver(options);
        });

        // ✅ Firefox with headless mode for CI
        drivers.put(BrowserType.FIREFOX, () -> {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            return new FirefoxDriver(options);
        });

        // ✅ Edge with headless mode
        drivers.put(BrowserType.EDGE, () -> {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            return new EdgeDriver(options);
        });
    }

    public static WebDriver getDriver(BrowserType browserType) {
        Supplier<WebDriver> driverSupplier = drivers.get(browserType);
        if (driverSupplier == null) {
            throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
        return driverSupplier.get();
    }
}
