package selenium.xpathcss;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Rough {


    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.get("chrome://downloads/");

        By srchBox= By.xpath("searchInput");

        JavascriptExecutor js=(JavascriptExecutor) driver;

        //((JavascriptExecutor) driver).executeScript("retu")


    }
}
