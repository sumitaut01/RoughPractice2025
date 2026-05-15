package selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeOptionsDemo {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        // =========================
        // Browser Window Settings
        // =========================

        // Start browser maximized
        options.addArguments("--start-maximized");

        // Open in incognito mode
        options.addArguments("--incognito");

        // Disable browser notifications
        options.addArguments("--disable-notifications");

        // Disable popup blocking
        options.addArguments("--disable-popup-blocking");

        // =========================
        // SSL / Certificate Handling
        // =========================

        // Ignore SSL certificate errors
        options.setAcceptInsecureCerts(true);

        // =========================
        // Headless Mode
        // =========================

        // Run without UI
        // options.addArguments("--headless=new");

        // =========================
        // Performance / Stability
        // =========================

        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");

        // =========================
        // Download Settings
        // =========================

        Map<String, Object> prefs = new HashMap<>();

        // Set default download folder
        prefs.put("download.default_directory",
                "C:\\Downloads");

        // Disable download popup
        prefs.put("download.prompt_for_download", false);

        // Allow automatic downloads
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);

        options.setExperimentalOption("prefs", prefs);

        // =========================
        // Disable Automation Banner
        // =========================

        options.setExperimentalOption(
                "excludeSwitches",
                new String[]{"enable-automation"}
        );

        // =========================
        // Create Driver
        // =========================

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");

        System.out.println(driver.getTitle());
        System.out.println("true");
    }
}