package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class RoughAgain {


   String url="https://testautomationpractice.blogspot.com/";

    @Test
    public void Test() throws InterruptedException, IOException {
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);



        String sParent=driver.getWindowHandle();
        By txtboxName= By.id("name");
        By chkSunday=By.xpath("//input[@type='checkbox' and @value='sunday']");
        By btnNewTab=By.xpath("//button[text()='New Tab']");

        driver.findElement(txtboxName).sendKeys("some data");
        System.out.println(driver.findElement(txtboxName).getDomProperty("name"));
        System.out.println(driver.getTitle());

        driver.findElement(btnNewTab).click();
        Set<String> sHandles=driver.getWindowHandles();

        System.out.println();

        String sChild="";
        for(String s:sHandles){
            if(!s.equals(sParent)){
                sChild=s;
                break;
            }
        }
        driver.switchTo().window(sChild);
        System.out.println(driver.getTitle());


       driver.close();

        driver.switchTo().window(sParent);
        System.out.println(driver.getTitle());




        //select
        By sel=By.id("country");
        WebElement select=driver.findElement(sel);
        Select sx=new Select(select);


        sx.selectByIndex(0);
        Thread.sleep(2000);

        sx.selectByVisibleText("Canada");
        Thread.sleep(2000);

        sx.selectByValue("usa");


        //Actions
        Actions actions=new Actions(driver);
        WebElement xpathDragFrom=driver.findElement(By.id("draggable"));
        WebElement xpathDragTo=driver.findElement(By.id("droppable"));


        actions.moveToElement(xpathDragFrom).build().perform();
        actions.dragAndDrop(xpathDragFrom,xpathDragTo).build().perform();
        File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr, new File("pp.png"));

        JavaScriptExecutor jsx= (JavaScriptExecutor)driver;



        //
        //driver.switchTo().alert().accept();








        driver.quit();

    }


    @Test
    public void WaitDemo(){
        String str="sumit";
        FluentWait<String> fw=new FluentWait(str);fw.pollingEvery(Duration.ofSeconds(1000));
        fw.ignoring(StaleElementReferenceException.class);

    }
}
