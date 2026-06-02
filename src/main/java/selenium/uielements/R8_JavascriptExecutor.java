package selenium.uielements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class R8_JavascriptExecutor {

    @Test
    public void R8(){

        String url="https://testautomationpractice.blogspot.com/";
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);

        JavascriptExecutor js=(JavascriptExecutor) driver;

        ////tr/td[contains(text(),'Smartphone')]/following-sibling::td/child::input[@type='checkbox']
        WebElement ele=driver.findElement(By.xpath("//tr/td[normalize-space()='Smartphone']/following-sibling::td/child::input[@type='checkbox']"));
       // js.executeScript("arguments[0].scrollIntoView()",ele);//works

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", ele);
        ele.click();


        driver.quit();
    }
}
