package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class R11_CheckboxStaleElement {

    //note  //<input type="checkbox" name="" value="" aria-hidden="true" checked= tabindex="-1"> means same as @checked=""
    ////*[@id="p_90/6741118031"]/span/a/div/label/input
    //<input type="checkbox" name="" value="" aria-hidden="true" checked="" tabindex="-1">
    ////input[@checked=""]


    /*

    Important interview understanding

Page refresh is not the only reason for stale elements.

Also happens when:

AJAX reloads section
React rerenders component
Angular rebuilds DOM
table refreshes dynamically
popup closes/reopens

Even without full page refresh.
     */


    public WebElement getElement(WebDriver driver, By by) {
        return driver.findElement(by);
    }

    @Test
    public void checkBox() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.in");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        By searchBox = By.id("twotabsearchtextbox");
        driver.findElement(searchBox).sendKeys("iphone");
        driver.findElement(searchBox).submit();
        Actions actions = new Actions(driver);
        By checkBox = By.xpath("//span[text()='Get It by Tomorrow']/preceding-sibling::div//label/input");

        WebElement checkbox = getElement(driver, checkBox);

        System.out.println("-------------------------------------------------");
        System.out.println(checkbox.getAttribute("checked"));
        System.out.println(checkbox.getDomAttribute("checked"));
        System.out.println("-------------------------------------------------");
        actions.scrollToElement(checkbox).build().perform();

        System.out.println(checkbox.isSelected());
        System.out.println(checkbox.isDisplayed());


        //driver.findElement(checkBox).click();//ElementClickInterceptedException

        actions.moveToElement(checkbox).click().build().perform();

        int count = 0;
        while (count < 2) {
            try {
                System.out.println(count);
                System.out.println(checkbox.isSelected());
                System.out.println(checkbox.isDisplayed());
                System.out.println("-------------------------------------------------");
                System.out.println(checkbox.getAttribute("checked"));
                System.out.println(checkbox.getDomAttribute("checked"));
                System.out.println("-------------------------------------------------");
                count = 2;
            } catch (StaleElementReferenceException oEx) {
                count++;
                checkbox = getElement(driver, checkBox);
                actions.scrollToElement(checkbox).build().perform();
            }

        }

        Thread.sleep(30000);
        driver.quit();

    }


    @Test
    public void Demo() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement ele = driver.findElement(By.id("name"));
        ele.sendKeys("hi");

        driver.navigate().refresh();
        // driver.navigate().back();
        // driver.navigate().forward();
        Thread.sleep(5000);
        ele.sendKeys("again");//org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found

    }


    @Test
    public void Demo_Catching() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement ele;

        ele=driver.findElement(By.id("name"));
        ele.sendKeys("hi");

        driver.navigate().refresh();
        try {
            ele.sendKeys("again");
        }
        catch (StaleElementReferenceException e) {
            ele = driver.findElement(By.id("name"));
            ele.sendKeys("again");
        }
        Thread.sleep(5000);
    }

    //wait.until(ExpectedConditions.refreshed(
    //        ExpectedConditions.presenceOfElementLocated(By.id("name"))
    //));




}













