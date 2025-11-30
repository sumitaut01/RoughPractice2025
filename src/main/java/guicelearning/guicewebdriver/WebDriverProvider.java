package guicelearning.guicewebdriver;

import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Provider = Factory Pattern inside Guice
//
//That’s all.
//
//🛠️ STEP 1: Create a Provider for WebDriver
public class WebDriverProvider implements Provider<WebDriver> {

    @Override
    public WebDriver get() {
        System.out.println("Creating a NEW WebDriver...");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

//This does:
//
//✔ New ChromeDriver each time
//✔ Maximize window
//✔ Logs creation
//✔ Can add options later
