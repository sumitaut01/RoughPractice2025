package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class R_10ScreenShot {

    public static void main(String[] args) throws IOException, InterruptedException {


        WebDriver driver = new ChromeDriver();

        By lnkJoin = By.xpath("//a[contains(text(),'Join us!')]");
        By lnkAll = By.xpath("//a");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");

        JavascriptExecutor js=(JavascriptExecutor)driver;

        TakesScreenshot tsc = (TakesScreenshot) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        File srcFile = tsc.getScreenshotAs(OutputType.FILE);
        File dest = new File("test.png");
        FileUtils.copyFile(srcFile,dest);

        System.out.println(driver.findElement(lnkJoin).getText());
        System.out.println("---------------------------------------");
        Thread.sleep(5000);
        driver.findElements(lnkAll).forEach(ele -> System.out.println(ele.getText()));

        System.out.println(js.executeScript("return document.title"));


        driver.quit();
    }
}
