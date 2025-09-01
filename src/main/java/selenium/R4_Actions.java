package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


//public class Actions
public class R4_Actions {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("somexpath"))).build().perform();
        driver.quit();
    }

}
