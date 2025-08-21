package selenium.loginbypass;



import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.util.Iterator;

public class R2_SetLocalStorage {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("about:blank");

        // Step 1: Open origin domain


        // Step 2: Load localStorage data from file
        String jsonStr = new String(Files.readAllBytes(new File("localstorage.json").toPath()));
        JSONObject storage = new JSONObject(jsonStr);

        // Step 3: Inject each key into localStorage
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Iterator<String> keys = storage.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = storage.getString(key);
            js.executeScript(String.format("localStorage.setItem('%s', '%s');", key, value));
        }
        driver.get("https://uat01.gpp.corporate.ingrammicro.com:7443/#/SystemDefault/configurator-program-rule");
        // Step 4: Refresh to simulate logged-in state
        driver.navigate().refresh();
    }
}

