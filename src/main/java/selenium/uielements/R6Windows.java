package selenium.uielements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class R6Windows {

    @Test
    public void Test(){

        String url="https://testautomationpractice.blogspot.com/";
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);

        System.out.println(driver.getTitle());
        String sParent= driver.getWindowHandle();
       WebElement ele= driver.findElement(By.xpath("//button[contains(text(),'New Tab')]"));
       ele.click();


       Set<String> sHandles=driver.getWindowHandles();
       String sChild="";
       for(String s:sHandles){
           if(!s.contains(sParent)){
               sChild=s;
               break;
           }
       }

       driver.switchTo().window(sChild);

        System.out.println(driver.getTitle());




        driver.quit();

    }


}
