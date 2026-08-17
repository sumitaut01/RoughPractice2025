package selenium.roughweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class R1_Rough {



    @Test
    public void Test1(){
        try {
            WebDriver driver = new ChromeDriver();
            driver.manage().deleteAllCookies();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().window().maximize();
            driver.get("https://demowebshop.tricentis.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By headerMenu_Computers = By.cssSelector(".top-menu a[href='/computers']");
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(headerMenu_Computers));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            By headerMenu_Desktops =
                    By.xpath("//a[contains(@href,'desktop')]");
            WebElement linkDesktop = wait.until(ExpectedConditions.elementToBeClickable(headerMenu_Desktops));
            linkDesktop.click();

            By sel_product_OrderBy =
                    By.id("products-orderby");
            WebElement selOrderSort = wait.until(ExpectedConditions.elementToBeClickable(sel_product_OrderBy));
            Select sel = new Select(selOrderSort);
            sel.selectByVisibleText("Name: A to Z");
            By prodTitle =
                    By.cssSelector(".product-title a");
            //how would user know page has been loaded
            WebElement products = wait.until(ExpectedConditions.elementToBeClickable(prodTitle));
            List<WebElement> prods = driver.findElements(prodTitle);
            System.out.println(prods.size());

            prods.forEach(prod -> System.out.println(prod.getText()));
            //Build your own cheap computer
            //Build your own computer
            //Build your own expensive computer
            //Desktop PC with CDRW
            //Elite Desktop PC
            //Simple Computer

            System.out.println("dummy");

            //click first product
            prods.get(0).click();
            By allRadio = By.cssSelector("input[type='radio']+label[for^='product_attribute']");
            WebElement radios = wait.until(ExpectedConditions.elementToBeClickable(allRadio));

            List<WebElement> slowRadio = driver.findElements(allRadio).stream().filter(ele -> ele.getText().equalsIgnoreCase("slow")).collect(Collectors.toList());
            slowRadio.get(0).click();

            By allchkBox = By.cssSelector("input[type='checkbox']+label[for^='product_attribute']");

            WebElement checkboxes = wait.until(ExpectedConditions.elementToBeClickable(allchkBox));

            List<WebElement> checkbox = driver.findElements(allchkBox).stream()
                    .filter(ele -> ele.getText().contains("Image Viever")).collect(Collectors.toList());
            checkbox.get(0).click();
            System.out.println("dummy");
        }
        catch (Exception oex){
            System.out.println("Facing exception below");
                    oex.printStackTrace();
        }
        finally
        {
            System.out.println("Closing driver using finally ");
        }













    }
}
