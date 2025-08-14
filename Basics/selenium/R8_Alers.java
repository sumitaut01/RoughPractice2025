package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class R8_Alers {

    public static void main(String[] args) {

//        public interface Alert {
//            void accept();
//            void dismiss();
//            String getText();
//            void sendKeys(String keysToSend);
//        }

        WebDriver driver = new ChromeDriver();

        By lnkJoin = By.xpath("//a[contains(text(),'Join us!')]");
        By lnkAll = By.xpath("//a");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().sendKeys("");
        driver.switchTo().alert().getText();


    }
}
