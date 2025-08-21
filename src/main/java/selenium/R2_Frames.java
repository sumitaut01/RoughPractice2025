package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class R2_Frames {


    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();

        driver.switchTo().frame(0);

        driver.switchTo().frame(1);

        driver.switchTo().defaultContent();// go to very top
        driver.switchTo().frame(0);

        driver.switchTo().frame(1);

    }
}
