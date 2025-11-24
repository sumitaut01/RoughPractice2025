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
        WebElement shadowHost0 = driver.findElement(By.cssSelector("downloads-manager"));
        SearchContext shadow0=shadowHost0.getShadowRoot();


        //shadow0

        WebElement shadowHost01=  shadow0.findElement(By.cssSelector("#toolbar"));
        SearchContext shadowRoot01 = shadowHost01.getShadowRoot();


        WebElement shadowHost02=  shadowRoot01.findElement(By.cssSelector("#toolbar"));
        SearchContext shadowRoot02 = shadowHost02.getShadowRoot();



        WebElement shadowHost03=  shadowRoot02.findElement(By.cssSelector("#search"));
        SearchContext shadowRoot03 = shadowHost03.getShadowRoot();


        WebElement shadowHost04=  shadowRoot03.findElement(By.cssSelector("#icon"));
        SearchContext shadowRoot04 = shadowHost04.getShadowRoot();


        WebElement ele=  shadowRoot03.findElement(By.cssSelector("#searchInput"));
        ele.sendKeys("test");




        driver.quit();
    }
}






