package selenium.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Rough01 {
    @Test
    public void method1() {

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        System.out.println(driver.getTitle());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("field-keywords")));
        driver.findElement(By.name("field-keywords")).sendKeys("iphone");
        driver.findElement(By.name("field-keywords")).submit();

//        driver.findElements(By.tagName("a")).forEach(a-> {
//            if(a.isDisplayed() && a.getText().length()>0){
//                System.out.println(a.getText());
//            }
//        });

        By els = By.xpath("//div[@data-cy='title-recipe']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(els));

        System.out.println(driver.findElements(els).size());

        driver.findElements(els).forEach(a -> a.isDisplayed());

        driver.findElements(els).stream().filter(a -> a.isDisplayed()).forEach(a ->
                {
                    if (!a.getText().toLowerCase().contains("spons"))
                        System.out.println(a.getText());

                }
        );
        driver.quit();
    }



    @Test
    public void Windows(){

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        System.out.println(driver.getTitle());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("field-keywords")));
        driver.findElement(By.name("field-keywords")).sendKeys("iphone");
        driver.findElement(By.name("field-keywords")).submit();

//        driver.findElements(By.tagName("a")).forEach(a-> {
//            if(a.isDisplayed() && a.getText().length()>0){
//                System.out.println(a.getText());
//            }
//        });

        By els = By.xpath("//div[@data-cy='title-recipe']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(els));

        System.out.println(driver.getTitle());

        String sParent=driver.getWindowHandle();
        System.out.println("parent is "+sParent);
        String sChild="";
//        for(WebElement el: els){
//          el.click();
//            break;
//        }



        for(String s:driver.getWindowHandles()){

            if(!s.equalsIgnoreCase(sParent)){
                sChild=s;
                break;
            }
        }

        driver.switchTo().window(sChild);

        System.out.println(driver.getTitle());
    }


}



