package selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class R3_FluentWaitClick {



@Test
        public void withByLocator(){
        WebDriver driver=new ChromeDriver();
        String url="https://testautomationpractice.blogspot.com/";
        By lnkHome= By.xpath("(//a[normalize-space()='Home'])[1]");
        driver.get(url);

        WebElement ele=driver.findElement(lnkHome);
        ele.click();
        driver.navigate().refresh();
        clickWithRetry(driver, lnkHome, 20);


        driver.quit();

    }


    @Test
    public void withWebElement() {
        WebDriver driver=new ChromeDriver();
        String url="https://testautomationpractice.blogspot.com/";
        By lnkHome= By.xpath("(//a[normalize-space()='Home'])[1]");
        driver.get(url);
        WebElement ele=driver.findElement(lnkHome);
        ele.click();
        driver.navigate().refresh();
        clickWithRetry(driver, ele, 20);
        driver.quit();
    }

    public static void clickWithRetry(WebDriver driver,By locator, int timeoutSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.withMessage("Waiting for "+locator.toString());
        wait.ignoring(StaleElementReferenceException.class)
                .until(d -> {
                    WebElement element = d.findElement(locator);
                    element.click();
                    return true;
                });
    }


    public static void clickWithRetry(WebDriver driver,WebElement element, int timeoutSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.withMessage("Waiting for "+element.toString());
        wait.ignoring(StaleElementReferenceException.class)
                .until(d -> {
                    element.click();
                    return true;
                });
    }
}