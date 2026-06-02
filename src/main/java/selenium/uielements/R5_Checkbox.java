package selenium.uielements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class R5_Checkbox {

    @Test
    public void R1(){

        By checkFemale = By.xpath("//input[@type='checkbox' and @value='sunday']");
        String url="https://testautomationpractice.blogspot.com/";
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        System.out.println(driver.findElement(checkFemale).isSelected());//false
        driver.findElement(checkFemale).click();
        System.out.println(driver.findElement(checkFemale).isSelected());//true
        String data=driver.findElement(checkFemale).getAttribute("value");//sunday
        System.out.println(data);
        driver.quit();

    }
}
