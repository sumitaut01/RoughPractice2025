package selenium.selenium4newfeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class R2_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.way2automation.com/way2auto_jquery/index.php");

        // input box above Select WebElement
        driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("Select"))).sendKeys("hi");
        Thread.sleep(4000);
        driver.quit();


//        driver.findElement(RelativeLocator.with(By.tagName("input")).below()
//                driver.findElement(RelativeLocator.with(By.tagName("input")).straightAbove()
//                        driver.findElement(RelativeLocator.with(By.tagName("input")).near()
//                                driver.findElement(RelativeLocator.with(By.tagName("input")).straightBelow()
//                                        driver.findElement(RelativeLocator.with(By.tagName("input")).straightLeftOf()
//                                                driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf()
//                                                        driver.findElement(RelativeLocator.with(By.tagName("input")).
    }
}
