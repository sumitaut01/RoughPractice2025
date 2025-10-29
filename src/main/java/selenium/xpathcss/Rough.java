package selenium.xpathcss;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Rough {


    public static void main(String[] args) {



        WebDriver driver=new ChromeDriver();

        driver.get("");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();


//        WebElement element=driver.findElement(By.xpath())
//        WebElement element=driver.findElement(By.cssSelector())
//        WebElement element=driver.findElement(By.className())
//        WebElement element=driver.findElement(By.tagName())
//        WebElement element=driver.findElement(By.linkText())
//        WebElement element=driver.findElement(By.partialLinkText())
//        WebElement element=driver.findElement(By.id())
//        WebElement element=driver.findElement(By.name(""))


    }
}
