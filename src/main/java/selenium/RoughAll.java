package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class RoughAll {


    @Test
    public void test() throws InterruptedException, IOException {

        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //WebDriverWait
        By lnk_Home=By.xpath("//button[text()='Home']");
        waitForElementClickable(driver,lnk_Home);
       // driver.findElement(lnk_Home).click();

        //radio
        By radio3=By.xpath("//input[@type='radio' and @value='radio3']");
        waitForElementClickable(driver,radio3);
        Thread.sleep(1000);
        driver.findElement(radio3).click();

        //checkbox
        By checkbox1=By.xpath("//input[@type='checkbox' and @value='option1']");
        waitForElementClickable(driver,checkbox1);
        Thread.sleep(1000);
        driver.findElement(checkbox1).click();

        //select
        By select=By.xpath("//select[@id='dropdown-class-example']");
        WebElement selbox=driver.findElement(select);
        waitForElementClickable(driver,select);

        Select selBox=new Select(selbox);
        Thread.sleep(1000);
        selBox.selectByValue("option1"); ///in value atribute

        Thread.sleep(1000);
        selBox.selectByVisibleText("Option3"); // whats visible to user

        Thread.sleep(1000);
        selBox.selectByIndex(2);

        System.out.println("-------Printing--------------------------------");
        selBox.getOptions().forEach(opt-> System.out.println(opt.getText()));


        //our alert-- javascriptexecutor
        JavascriptExecutor js=(JavascriptExecutor)driver;
        // Inject an alert
        js.executeScript("alert('Hello! This is an alert via JavaScriptExecutor');");
        driver.switchTo().alert().accept();

        //take screenshot
        TakesScreenshot ts=(TakesScreenshot)driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("screenshot.png"));


        Thread.sleep(1000);
        By btnLaert=By.id("confirmbtn");
        WebElement btnAlert=driver.findElement(btnLaert);
        btnAlert.click();
        driver.switchTo().alert().accept();


       //Actions
       WebElement parent =driver.findElement(By.id("mousehover"));
       Actions actwork=new Actions(driver);

        Thread.sleep(1000);
       actwork.moveToElement(parent)
               .moveToElement(driver.findElement(By.xpath("//a[@href='#top']")))
               .click()
               .build()
               .perform();









        //new Window

        By newWindow=By.xpath("//button[@id='openwindow']");
        WebElement newWindowele=driver.findElement(newWindow);
        newWindowele.click();



        String curentWindow=driver.getWindowHandle();
        String otherWindow="";
        Set<String> wHandles=driver.getWindowHandles();

        for(String s:wHandles){
            String sTitle=driver.switchTo().window(s).getTitle();
            System.out.println(sTitle);
            if(sTitle.toLowerCase().startsWith("qa")){
                otherWindow=driver.getWindowHandle();
                break;
            }
        }

        Thread.sleep(1000);
        driver.close();


        //Webtable


        driver.close();

        driver.quit();





    }



    public static WebElement waitForElementClickable(WebDriver driver, By by){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(500))
                .ignoring(NotFoundException.class);
      return  wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
