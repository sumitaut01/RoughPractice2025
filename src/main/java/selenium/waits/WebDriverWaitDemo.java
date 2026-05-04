package selenium.waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebDriverWaitDemo {


    @Test
    public void Rough290426() throws InterruptedException {

        JavascriptExecutor js;
        WebDriver driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        By searchBox = By.id("twotabsearchtextbox");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.com");
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        System.out.println(driver.getTitle());
        ele.sendKeys("iphone");
        ele.submit();

        By resultLabel = By.xpath("//h2[text()='Results']");

        wait.until(ExpectedConditions.numberOfElementsToBe(resultLabel, 1));

        System.out.println(driver.getTitle());

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (WebElement el : allLinks) {
            System.out.println("--->" + el.getText() + "<---");
        }

        By chkApple = By.xpath("//div[@id='brandsRefinements']/descendant::a[normalize-space()='Apple']");

        WebElement chkApplebox = wait.until(ExpectedConditions.elementToBeClickable(chkApple));
        js.executeScript("arguments[0].scrollIntoView(true);", chkApplebox);
        js.executeScript("arguments[0].click()", chkApplebox);
        // chkApplebox.click();

        Thread.sleep(5000);

        driver.quit();
    }


    @Test
    public void Rough290426_2() {
        JavascriptExecutor js;
        WebDriver driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class).withMessage("---locating---");
        By searchBox = By.id("twotabsearchtextbox");
        driver.manage().
                window().
                maximize();
        driver.manage().
                deleteAllCookies();
        driver.get("https://testautomationpractice.blogspot.com/");



        Actions act=new Actions(driver);
        By selectCountry=By.id("country");
        WebElement select=wait.until(ExpectedConditions.elementToBeClickable(selectCountry));

                Select sel=new Select(select);
                sel.selectByVisibleText("Canada");




                //failing forcefully
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));//this will fail after 10 seconds



    }



    @Test
    public void ShadowElement(){

        JavascriptExecutor js;
        WebDriver driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class).withMessage("---locating---");
        By searchBox = By.id("twotabsearchtextbox");
        driver.manage().
                window().
                maximize();
        driver.manage().
                deleteAllCookies();
        driver.get("https://testautomationpractice.blogspot.com/");

        //handling shadow dow

        WebElement host= driver.findElement(By.cssSelector("#shadow_host"));
        SearchContext context=host.getShadowRoot();

        WebElement ele = context.findElement(By.cssSelector("input[type='text']"));

// 4. Interact
        ele.sendKeys("hii");


        System.out.println("hi");








    }
}
