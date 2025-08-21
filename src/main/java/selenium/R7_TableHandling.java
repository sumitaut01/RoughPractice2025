package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class R7_TableHandling {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));


        By tblHeader= By.xpath("//table//th");
        By tblRw= By.xpath("//table//tr");


        for (int i=0;i< driver.findElements(tblRw).size();i++) {
            for (int j = 0; j < driver.findElements(tblHeader).size(); j++) {
                System.out.print(driver.findElement(By.xpath("//table//tr[" + i + "]/td[" + j + "]")).getText() + " ");
            }
            System.out.println("");
        }
    }
}
