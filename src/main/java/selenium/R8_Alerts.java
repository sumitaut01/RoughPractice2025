package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class R8_Alerts {

    public static void main(String[] args) {

//        public interface Alert {
//            void accept();
//            void dismiss();
//            String getText();
//            void sendKeys(String keysToSend);
//        }


        //  Alert alert=new WebDriverWait(driver,Duration.ofSeconds(10))
        //                .until(ExpectedConditions.alertIsPresent());

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



       // Alert alert=


    }



    @Test
    public void ViaWebDriverWait(){

        WebDriver driver = new ChromeDriver();
        By lnkJoin = By.xpath("//a[contains(text(),'Join us!')]");
        By lnkAll = By.xpath("//a");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Alert alert=new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
//        alert.dismiss();
//        alert.sendKeys("");
//        alert.getText();
    }


    //untested.. did not work for me...
    @Test
    public void ViaChromeOptions(){
        WebDriver driver=new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setCapability("unhandledPromptBehavior", "dismiss");
        // options: "accept", "dismiss", "accept and notify", "dismiss and notify", "ignore"
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        By btnAlert=By.xpath("//button[normalize-space()='Click for JS Confirm']");
        driver.findElement(btnAlert).click();
        System.out.println("dismissed");
    }
}
