package selenium;

import groovy.json.JsonOutput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class R2_Frames {

    public static void main(String[] args) {


        // WebDriver frame(int index);
        //
        //        WebDriver frame(String nameOrId);
        //
        //        WebDriver frame(WebElement frameElement);

        WebDriver driver = new ChromeDriver();
        // Assume the browser is already at a page with multiple frames.
        // Correct way to switch to the first frame (index 0)
        driver.switchTo().frame(0);
        // Perform actions within frame 0...
        driver.findElement(By.id("someId")).click();
        // Return to the main page (default content) to switch to another frame
        driver.switchTo().defaultContent();
        // Correct way to switch to the second frame (index 1)
        driver.switchTo().frame(1);
        // Perform actions within frame 1...
        // Return to the main page again to resume work on the main page or switch to a different frame
        driver.switchTo().defaultContent();
    }



    @Test
    public void Test(){

 //question: if the element was inside the frame and i am trying to access it, what exception i will get

        WebDriver driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://the-internet.herokuapp.com/iframe?utm_source=chatgpt.com");

        //driver.switchTo().frame("mce_0_ifr");
        //Below Element inside frame
        By text=By.cssSelector("[data-id='mce_0']");


        // below exception when frame is not selected
        //org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"[data-id='mce_0']"}
        System.out.println(driver.findElement(text).getText());//Your content goes here.

    }
}