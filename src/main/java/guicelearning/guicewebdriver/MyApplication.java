package guicelearning.guicewebdriver;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;

//STEP 3: Inject WebDriver in your class
public class MyApplication {

    private final WebDriver driver;

    @Inject
    public MyApplication(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.get("https://google.com");
    }
}
