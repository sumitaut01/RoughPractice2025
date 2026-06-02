package selenium.mmt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MMTTest01 {

    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();


        driver.get("https://www.makemytrip.com/");
      //  driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-30/05/2026&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&lang=eng");

        By result=By.xpath("//div[@class='flexOne timeInfoLeft']//p[normalize-space()='19:20']/ancestor::div[@class='makeFlex']/following-sibling::div//descendant::div[@data-test='component-fare']/span");

        System.out.println(driver.findElement(result).getText());
        System.out.println("done");



    }
}
