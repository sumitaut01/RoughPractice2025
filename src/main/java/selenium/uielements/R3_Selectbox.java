package selenium.uielements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class R3_Selectbox {

    @Test
    public void R1() throws InterruptedException {

        String url="https://testautomationpractice.blogspot.com/";
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);


        By selCountry = By.id("country");
        WebElement ele=driver.findElement(selCountry);
        Select sel=new Select(ele);

        sel.selectByVisibleText("Canada");
        Thread.sleep(4000);
        sel.selectByIndex(0);
        Thread.sleep(4000);
        sel.selectByValue("germany");
        Thread.sleep(4000);
        driver.quit();
    }
}
