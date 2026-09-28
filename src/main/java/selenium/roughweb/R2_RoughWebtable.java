package selenium.roughweb;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.time.Duration;

public class R2_RoughWebtable {


    public static void main(String[] args) throws FileNotFoundException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        By webTable = By.xpath("//table[@name='BookTable']");

        By by_headers = By.xpath("//table[@name='BookTable']//tr/th");
        By by_rows = By.xpath("//table[@name='BookTable']//tr");


        TakesScreenshot sc=(TakesScreenshot) driver;

        JavascriptExecutor js=(JavascriptExecutor) driver;
        // Arguments , scrollintoview fails... js is casesentisive inside below
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(webTable));

        File f=sc.getScreenshotAs(OutputType.FILE);
        int cols = driver.findElements(by_headers).size();
        int rows = driver.findElements(by_rows).size();
        for (int i = 2; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[" + j + "]")).getText());
                System.out.print(" ");
            }
            System.out.println(" ");
        }
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        driver.quit();
    }
}

/*

Learn Selenium Amit Selenium 300
Learn Java Mukesh Java 500
Learn JS Animesh Javascript 300
Master In Selenium Mukesh Selenium 3000
Master In Java Amod JAVA 2000
Master In JS Amit Javascript 1000
 */
