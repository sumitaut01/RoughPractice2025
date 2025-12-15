package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;


public class JavaScriptExecutor {

    public static void main(String[] args) throws IOException {

        WebDriver driver;
        driver=new ChromeDriver();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement button= driver.findElement(By.xpath("somexpth"));
        // Click an element using JavaScript
        js.executeScript("arguments[0].click();", button);

        TakesScreenshot sc=(TakesScreenshot) driver;
        File file=sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("D:\\Resurrection 2025.png"));
    }
}
