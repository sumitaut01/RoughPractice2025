package selenium;

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
        driver.get("");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        String sParent=driver.getWindowHandle();

        Set<String> sHandles = driver.getWindowHandles();
        for (String s : sHandles) {
            if (driver.switchTo().window(s).getTitle().equals("somehandles")) {
                driver.switchTo().window(s);
            }
        }
        driver.quit();
    }


    @Test
    public void SwitchToNewWindow() {

        WebDriver driver = new ChromeDriver();
        driver.get("");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();



        driver.switchTo().newWindow(WindowType.WINDOW);//window
        driver.switchTo().newWindow(WindowType.TAB);//tab

    }
}
