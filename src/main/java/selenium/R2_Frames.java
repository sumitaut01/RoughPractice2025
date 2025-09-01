package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class R2_Frames {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        // Assume the browser is already at a page with multiple frames.
        // Correct way to switch to the first frame (index 0)
        driver.switchTo().frame(0);
        // Perform actions within frame 0...
        // e.g., driver.findElement(By.id("someId")).click();
        // Return to the main page (default content) to switch to another frame
        driver.switchTo().defaultContent();
        // Correct way to switch to the second frame (index 1)
        driver.switchTo().frame(1);
        // Perform actions within frame 1...
        // Return to the main page again to resume work on the main page or switch to a different frame
        driver.switchTo().defaultContent();
    }
}