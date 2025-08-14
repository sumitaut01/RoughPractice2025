package selenium.loginbypass;
import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class R1_ExtractLocalStorage {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 1: Go to login page
        driver.get("https://uat01.gpp.corporate.ingrammicro.com:7443/#/SystemDefault/configurator-program-rule");

        // Step 2: Pause to allow manual login (MFA)
        System.out.println("Log in manually. You have 60 seconds...");
        Thread.sleep(10000);  // OR wait for a certain element to appear after login

        // Step 3: Dump localStorage into a Map
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> localStorage = (Map<String, Object>) js.executeScript(
                "let items = {}; " +
                        "for (let i = 0; i < localStorage.length; i++) { " +
                        "   let key = localStorage.key(i); " +
                        "   items[key] = localStorage.getItem(key); " +
                        "} return items;"
        );

        // Step 4: Write to JSON file
        try (FileWriter file = new FileWriter("localstorage.json")) {
            file.write(new org.json.JSONObject(localStorage).toString(4));
            System.out.println("LocalStorage saved to localstorage.json");
        }

        driver.quit();
    }
}

