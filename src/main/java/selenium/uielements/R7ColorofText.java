package selenium.uielements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class R7ColorofText {

    public static void main(String[] args) {

      By xpath=By.xpath("//input[@id='amount']");
      By checkFemale = By.xpath("//input[@type='checkbox' and @value='sunday']");
      String url="https://testautomationpractice.blogspot.com/";
      WebDriver driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.get(url);

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(xpath));

        System.out.println(driver.findElement(xpath).getAttribute("style"));
        //border: 0px; color: rgb(246, 147, 31); font-weight: bold;

        System.out.println(driver.findElement(xpath).getCssValue("color"));
        //rgba(246, 147, 31, 1)

        driver.quit();




    }
}
