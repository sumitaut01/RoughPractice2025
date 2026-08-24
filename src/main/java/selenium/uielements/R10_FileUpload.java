package selenium.uielements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class R10_FileUpload {
    @Test
    public void Demo() {

        WebDriver driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.id("singleFileInput")).sendKeys("C:\\Users\\sumit\\Downloads\\composition_vs_aggregation.html");
        driver.findElement(By.xpath("//button[text()='Upload Single File']"));

        driver.quit();


    }
}
