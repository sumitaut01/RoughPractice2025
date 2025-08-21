package selenium.loginbypass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class R3_EdgeDriver {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "C:\\Users\\inraus02\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        // Step 1: Go to login page
        driver.get("https://uat01.gpp.corporate.ingrammicro.com:7443/#/SystemDefault/configurator-program-rule");

        Thread.sleep(10000);

        driver.quit();


    }
}
