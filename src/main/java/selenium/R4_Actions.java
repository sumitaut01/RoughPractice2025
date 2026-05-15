package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


//public class Actions
public class R4_Actions {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        Actions actions=new Actions(driver);//..notice the driver.  Select uses Webelement
        actions.moveToElement(driver.findElement(By.xpath("somexpath"))).build().perform();
        driver.quit();
    }


    @Test
    public void Rough(){
     WebDriver driver=new ChromeDriver();
     Actions act=new Actions(driver);
     driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
     WebElement name=driver.findElement(By.id("login1"));
     act.moveToElement(name).doubleClick().sendKeys("test").build().perform();
     driver.quit();
    }

}
