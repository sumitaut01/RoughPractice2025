package selenium.waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class R2_MyFluentWait {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))      // total wait time
                .pollingEvery(Duration.ofSeconds(1))      // check every 1 sec
                .ignoring(Exception.class);               // ignore exceptions


        //Calling
        wait.until(d -> d.getTitle().equals("something"));




    }
}
