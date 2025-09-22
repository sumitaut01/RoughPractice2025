package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.SearchContext;

public class ShadowDomHandler {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("chrome://downloads/"); // Replace with a URL that has a Shadow DOM

        // 1. Locate the Shadow Host element
        WebElement shadowHost = driver.findElement(By.cssSelector("downloads-manager"));

        // 2. Get the Shadow Root
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        // For older Selenium versions or specific scenarios, you might need to use JavaScript Executor
         SearchContext shadowRoot1 = (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowRoot);

        // 3. Find the element inside the Shadow Root using its CSS selector
        WebElement buttonInsideShadowDom = shadowRoot.findElement(By.cssSelector("#button-in-shadow-dom"));

        // 4. Perform an action on the element
        buttonInsideShadowDom.click();
        
        System.out.println("Clicked the element inside the Shadow DOM!");

        driver.quit();
    }
}