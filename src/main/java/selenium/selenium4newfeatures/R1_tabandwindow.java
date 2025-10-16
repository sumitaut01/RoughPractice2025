package selenium.selenium4newfeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class R1_tabandwindow {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();

        driver.get("http://www.google.com");


        // Open a new tab and switch to it
        driver.switchTo().newWindow(WindowType.TAB);

        Thread.sleep(3000);
        driver.get("http://www.rediff.com");


// Open a new browser window and switch to it
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(3000);
        driver.get("http://www.facebook.com");
        Thread.sleep(3000);

        driver.close();
        Thread.sleep(3000);
        driver.quit();
    }
}
