package selenium.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Rough2 {


    @Test
    public void demo() throws InterruptedException {


        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://testautomationpractice.blogspot.com/");


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.ignoring(Exception.class)
                .pollingEvery(Duration.ofSeconds(500)).withMessage("Waiting")
                .withTimeout(Duration.ofSeconds(25));


        //new tab button
        By btnNewTab= By.xpath("//button[normalize-space()='New Tab']");
        String sParentWindow=driver.getWindowHandle();

        System.out.println("Printing parent title=>"+driver.getTitle());
        driver.findElement(btnNewTab).click();


        Set<String> sWindows=driver.getWindowHandles();
        String sChild="";

        for(String s:sWindows){

            if(!s.equalsIgnoreCase(sParentWindow)){
                sChild=s;
                break;
            }


            driver.switchTo().window(sChild);
            System.out.println("Printing child title=>"+driver.getTitle());



            try {
                Thread.sleep(2000);
            }
            catch (Exception e){
                System.out.println(e.toString());
            }



            driver.close();
            Thread.sleep(2000);


            driver.switchTo().window(sParentWindow);//if notswitched
            System.out.println("Printing  title after closing child=>"+driver.getTitle());//no such window: target window already closed
            Thread.sleep(2000);
            driver.quit();
        }








    }
}
