package selenium.svggraphandshadowdom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShadowDOM {
 
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("chrome://downloads/");
		WebElement root = driver.findElement(By.cssSelector("downloads-manager"));

		//WebElement shadowRoot1 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root);
		WebElement shadowRoot1 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root);

		WebElement root2 = shadowRoot1.findElement(By.cssSelector("downloads-toolbar"));
		WebElement shadowRoot2 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root2);
 
		WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
		WebElement shadowRoot3 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root3);

		WebElement root4 = shadowRoot3.findElement(By.cssSelector("cr-toolbar-search-field"));
		WebElement shadowRoot4 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",root4);
		shadowRoot4.findElement(By.cssSelector("#searchInput")).sendKeys("Hello");
 
	}
 
}