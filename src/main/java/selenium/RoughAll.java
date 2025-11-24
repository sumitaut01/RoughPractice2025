package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class RoughAll {


    @Test
    public void Remote() throws MalformedURLException {

        ChromeOptions options=new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"), options);
        driver.get("http://www.google.com");
        driver.quit();

    }


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
        System.out.println("---start--radio is selected");
        System.out.println(driver.findElement(radio3).isSelected());
        System.out.println("---end--radio is selected");



        //checkbox
        By checkbox1=By.xpath("//input[@type='checkbox' and @value='option1']");
        waitForElementClickable(driver,checkbox1);
        Thread.sleep(1000);
        driver.findElement(checkbox1).click();
        System.out.println("-----start--checkbox is selected");
        System.out.println(driver.findElement(checkbox1).isSelected());
        System.out.println("-----end--checkbox is selected");

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





       //Other actions methods

//        actwork.scrollToElement()
//        actwork.dragAndDrop(, )
//        actwork.click()
//        actwork.moveToElement(, )
//
//        actwork.contextClick()
//        actwork.keyDown(, Keys.ARROW_DOWN)
//        actwork.setActiveKeyboard()

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
        driver.switchTo().window(curentWindow);



        By tblHeader=By.xpath("//table[@name='courses']/tbody//tr/th");
        By tblRows=By.xpath("//table[@name='courses']/tbody//tr");


        String colData="//table[@name='courses']/tbody//tr[#ROW]/td[#COL]";

        int eleHdr=driver.findElements(tblHeader).size();
        int eleRows=driver.findElements(tblRows).size();
        List<HashMap<String,String>> data=new ArrayList<>();

        LinkedHashMap<String,String> xx;
        for(int i=2;i<=eleRows;i++){
            xx=new LinkedHashMap<>();

            for (int j=1;j<eleHdr;j++){

               xx.put(driver.findElement(By.xpath("//table[@name='courses']/tbody//tr[1]/th[#HEADER]".replace("#HEADER", ""+j))).getText(),
                       driver.findElement(By.xpath("//table[@name='courses']/tbody//tr["+i+"]/td[#DATA]".replace("#DATA",""+j))).getText());

                System.out.println(xx);
            }

            data.add(xx);


        }

        System.out.println(data.size());
        System.out.println(data);





        driver.quit();





    }



    public static WebElement waitForElementClickable(WebDriver driver, By by){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(500))
                .ignoring(NotFoundException.class);
      return  wait.until(ExpectedConditions.elementToBeClickable(by));
    }



    public void practice(){



//        WebDriver driver=new ChromeDriver();
//
//
//        driver.get("some");
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//
//
//
//        String parent=driver.getWindowHandle();
//
//
//        driver.findElement("").click();
//
//
//
//        Set<String> sHandles=driver.getWindowHandles();
//        String child="";
//        for(String s:sHandles){
//
//         if(!s.equalsIgnoreCase(parent)){
//             driver.switchTo().window(s);
//
//             child=driver.getWindowHandle();
//             driver.getTitle();
//             driver.close();
//
//         }
//
//        }
//
//
//        driver.switchTo().window(parent);
//
//
//
//        Actions act=new Actions(driver);
//
//        act.moveToElement("").click();
//
//
//        Select sel=new Select("we");
//
//        sel.selectByVisibleText();
//        sel.selectByValue();
//        sel.selectByIndex();
//
//
//
//
//
//        WebElement chk= driver.findElement("");
//                //input[@type='checkbox']/
//
//
//
//
//
//     driver.switchTo().newWindow(WindowType.WINDOW)






    }
}
