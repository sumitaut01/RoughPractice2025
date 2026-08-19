package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class R3_WindowsSwitching {

    @Test
    public void DemoSwitch() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://testautomationpractice.blogspot.com/");

        String sParent=driver.getWindowHandle();
        System.out.println("Parent Window title is "+driver.getTitle());
//Parent Window title is Automation Testing Practice
        By btnNewTab=By.xpath("//button[contains(text(),'New Tab')]");
        driver.findElement(btnNewTab).click();
        System.out.println("Current Window title is "+driver.getTitle());
//Current Window title is Automation Testing Practice
        Set<String> sHandles = driver.getWindowHandles();
        for (String s : sHandles) {
            if(!s.equals(sParent)) {
                driver.switchTo().window(s);
                System.out.println("Child Window title is "+driver.getTitle());
                //Child Window title is SDET-QA Blog
            }
        }
        driver.quit();
    }


    @Test
    public void SwitchToNewWindow() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("Parent Window title is "+driver.getTitle());
        driver.switchTo().newWindow(WindowType.WINDOW);//window
        driver.switchTo().newWindow(WindowType.TAB);//tab

        driver.quit();

    }
}
