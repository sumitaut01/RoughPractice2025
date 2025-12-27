package selenium;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rough {

    @Test
    public void Rough() {
        String url = "https://testautomationpractice.blogspot.com/";
        By newTabButton = By.xpath("//button[text()='New Tab']");

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        String title = driver.getTitle().toLowerCase();
        Assert.assertTrue(title.contains("automation"));

        String sParentWindow = driver.getWindowHandle();

        System.out.println("Parent Window Below");
        System.out.println(sParentWindow);
        System.out.println(driver.getTitle());

        Assert.assertTrue(driver.findElement(newTabButton).isEnabled());

        driver.findElement(newTabButton).click();
        System.out.println("After Clicking new tab button");
        System.out.println(driver.getTitle());

        String sChild = "";
        for (String s : driver.getWindowHandles()) {

            if (!s.equalsIgnoreCase(sParentWindow)) {
                sChild = s;
                System.out.println("Child Window Below");
                System.out.println(sChild);
            }
        }

        driver.switchTo().window(sChild);
        String childTitle = driver.getTitle();
        System.out.println("--Printing child title below--");
        System.out.println(childTitle);
        driver.close();


        // now we need to switch  back to parent
        driver.switchTo().window(sParentWindow);
        System.out.println(driver.getTitle());


        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.rediff.com");
        System.out.println(driver.getTitle());
        driver.close();


        //again we need to switch to parent else it will be error
//        String whatWindowNow = driver.getTitle();
//        System.out.println(whatWindowNow);
        System.out.println("Again Switching to parent");
        driver.switchTo().window(sParentWindow);
        System.out.println(driver.getTitle());


        //textbox

        By firstName = By.id("name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys("s", "u", "m");

        String enteredText = driver.findElement(firstName).getAttribute("value");//keypoint
        Assert.assertEquals("sum", enteredText);

        //radio
        By radioBtnMale = By.id("male");
        boolean isRadioMaleSelected = driver.findElement(radioBtnMale).isSelected();//keypoint
        System.out.println("isRadioMaleSelected");
        System.out.println(isRadioMaleSelected);

        driver.findElement(radioBtnMale).click();
        System.out.println("isRadioMaleSelected");
        System.out.println(driver.findElement(radioBtnMale).isSelected());//


        //checkboxes
        By checkboxMonday = By.id("monday");
        boolean ischeckboxMonday = driver.findElement(checkboxMonday).isSelected();
        System.out.println(ischeckboxMonday);

        driver.findElement(checkboxMonday).click();
        System.out.println("ischeckboxMonday");
        System.out.println(driver.findElement(checkboxMonday).isSelected());


        //drop downs//select
        WebElement country = driver.findElement(By.id("country"));
        Select sel = new Select(country);
        sel.selectByVisibleText("Germany");

        String selected = sel.getFirstSelectedOption().getText();////keypoint
        List<WebElement> els = sel.getAllSelectedOptions();


        for (WebElement el : els) {
            System.out.println(el.getText());
            System.out.println(el.isSelected());
        }


        //pop ups
        By popupPrompt = By.id("promptBtn");
        driver.findElement(popupPrompt).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        System.out.println("pop up accepted");


        // myFluent

//        fluentString("sss").until(s->s.length()>5);
//        System.out.println("dummy");

        //Actions
        WebElement ele = driver.findElement(By.xpath("//button[@class='dropbtn']"));

        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();


        // act.contextClick()
        //act.doubleClick()


        WebElement flyOutMEnu = driver.findElement(By.xpath("//div[@class='dropdown-content']/a[text()='Mobiles']"));
        System.out.println(flyOutMEnu.isDisplayed());
        flyOutMEnu.click();

        System.out.println(driver.getCurrentUrl());


        driver.quit();


    }


    public static Wait<String> fluentString(String myStr) {
        Wait<String> mywait = new FluentWait<>(myStr)
                .pollingEvery(Duration.ofMillis(1000))
                .withTimeout(Duration.ofSeconds(5))
                .withMessage("waiting");
        return mywait;
    }


    @Test
    public void Iteration() {

        Set<Integer> str = new HashSet<>();


        int[] arr = {1, 2, 3, 4, 6, 5, 5};


        for (int i : arr) {
            if (!str.add(i))
                System.out.println("Duplicates below");
            System.out.println(i);
        }
    }


    @Test
    public void SecondInArray() {
        int arr[]={1,2,4,0,9,2,120,150};
        int first=0;
        int second=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }
            else if(arr[i]>second) {
                second = arr[i];
            }
        }

        System.out.println(first);
        System.out.println(second);

    }


    @Test
    public void RoughAgain(){

        String url="https://testautomationpractice.blogspot.com/";

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        driver.get(url);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
      //  WebElement name=driver.findElement(By.xpath("name"));


        name.click();
        name.sendKeys("sumit");
        String enteredText=name.getAttribute("value");

        WebElement table=driver.findElement(By.xpath("//table[@name='BookTable']"));
        List<WebElement> headers= driver.findElements(By.xpath("//table[@name='BookTable']//tr//th"));
        int intCols= headers.size();

        List<WebElement> rows= driver.findElements(By.xpath("//table[@name='BookTable']//tr"));

        JavascriptExecutor js= (JavascriptExecutor) driver;

       // js.executeScript("arguments[0].scrollintoView(true)", table);
        js.executeScript("arguments[0].scrollIntoView(true);", table);


        Actions act=new Actions(driver);
        act.scrollToElement(table);



        int intRows=rows.size();
        for(int i=2;i<=intRows;i++) {

            String data="";
            for (int j = 1; j <= intCols; j++) {
                 data = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[" + i + "]/td[" + (j) + "]")).getText();
                System.out.print(data +" ");
            }

            System.out.println("");
        }


        System.out.println("Parent Window handle is below");
        String sParent=driver.getWindowHandle();

        //new window
        WebElement pop=driver.findElement(By.xpath("//button[@id='PopUp']"));
        act.scrollToElement(pop).click().build().perform();

        System.out.println("totla window handles are");
        System.out.println(driver.getWindowHandles().size());

        String sChildWindow="";
        for (String s:driver.getWindowHandles()){
            System.out.println(s);

            if(!s.equalsIgnoreCase(sParent)){
                sChildWindow=s;
                driver.switchTo().window(sChildWindow);

                System.out.println(driver.getTitle());

                try {
                    Thread.sleep(2000);
                }
                catch (Exception oEx){

                    System.out.println("Exceptio");
                }

                driver.close();
                System.out.println("switching to parent");
                driver.switchTo().window(sParent);
                System.out.println(driver.getTitle());
                driver.close();
            }
        }

















    }
}



