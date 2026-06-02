package selenium.uielements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;

public class R2_Checkbox {

    @Test
    public void R1(){

        By radioFemale= By.xpath("//input[@type='radio' and @value='female']");

        String url="https://testautomationpractice.blogspot.com/";
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        System.out.println(driver.findElement(radioFemale).isSelected());//false
        driver.findElement(radioFemale).click();
        System.out.println(driver.findElement(radioFemale).isSelected());//true
        String data=driver.findElement(radioFemale).getAttribute("value");//female
        System.out.println(data);
        driver.quit();

    }
}
