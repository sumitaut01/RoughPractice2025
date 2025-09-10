package selenium.webdriverlistenereventfiringdecorator;

import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
 
public class EventListenerSample {
 
	public static void main(String[] args) {
 
 
		
		WebDriver webdriver = new ChromeDriver();
		
		WebDriverListener listener = new MyListener();
		WebDriver driver = new EventFiringDecorator<WebDriver>(listener).decorate(webdriver);
 
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("password");
		driver.quit();
		
		
		
	}
 
}





 
 class MyListener implements WebDriverListener{
	
	
	public void afterClick(WebElement element) {
		
		System.out.println("Clicking on an Element : "+element);
		
	}
	
	
	
	public void afterQuit(WebDriver driver) {
		
		System.out.println("Test execution completed");
		
	}
	
	public void afterGet(WebDriver driver, String url) {
		
		
		System.out.println("Navigated to : "+url);
	}
	
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		
		
		System.out.println("Typing in an Element : "+element +" entered the value as : ");
		
		for(int i=0; i<keysToSend.length; i++) {
			
			System.out.println(keysToSend[i]+" ");
		}
		
		
	}
	
 
}