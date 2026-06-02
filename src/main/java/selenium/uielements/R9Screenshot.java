package selenium.uielements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class R9Screenshot {

    @Test
    public void R9() throws IOException {


        WebDriver driver=new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");

        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/main/java/selenium/uielements/result.jpg"));


        driver.quit();




    }
}
