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
public class DriverFactory {
    private static final EnumMap<BrowserType, Supplier<WebDriver>> drivers =
            new EnumMap<>(BrowserType.class);

    static {
        drivers.put(BrowserType.CHROME, ChromeDriver::new);
        drivers.put(BrowserType.FIREFOX, FirefoxDriver::new);
        drivers.put(BrowserType.EDGE, EdgeDriver::new);
    }

    public static WebDriver getDriver(BrowserType browserType) {
        Supplier<WebDriver> driverSupplier = drivers.get(browserType);
        if (driverSupplier == null) {
            throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
        return driverSupplier.get();
    }
}
