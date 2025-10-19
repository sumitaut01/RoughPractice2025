package selenium.selenium4newfeatures;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class R4_ElementScreenShot {

    public static void main(String[] args) throws InterruptedException, IOException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // input box above Select WebElement
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("sumit");
        File file=driver.findElement(By.xpath("//input[@name='name']")).getScreenshotAs(OutputType.FILE);
        Files.copy(file, new File("elementscreemshot.png"));

        Thread.sleep(4000);
        driver.quit();


    }
}

