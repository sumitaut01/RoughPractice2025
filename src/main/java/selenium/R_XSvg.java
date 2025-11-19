package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class R_XSvg {



@Test
        public void svgDemo(){
WebDriver driver=new ChromeDriver();

        driver.get("https://www.flipkart.com/");
        WebElement ele=driver.findElement(By.xpath("//*[local-name()='svg' and @fill='none']"));
        ele.click();
        driver.quit();
    }

    @Test
        public void Test(){
            WebDriver driver=new ChromeDriver();
            driver.get("https://petdiseasealerts.org/forecast-map");

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
            var ele=driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g' and @class='region']"));
            System.out.println(ele.size());

            for (WebElement e:ele){

                    System.out.println(e.getDomAttribute("id"));
            }
            driver.quit();

    }
}
