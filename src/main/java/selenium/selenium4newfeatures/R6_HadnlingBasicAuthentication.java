package selenium.selenium4newfeatures;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class R6_HadnlingBasicAuthentication {

    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();
        ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
        driver.get("https://the-internet.herokuapp.com");

//        //selenium 3 way
//        driver.get("https://admin:admin@the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.quit();
    }
}
