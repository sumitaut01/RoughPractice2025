package demo.dockerimagerun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerRun {
    @Test
    public void Run() throws MalformedURLException {
    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver chromeDriver = new RemoteWebDriver(
            new URL("http://localhost:4444/wd/hub"), chromeOptions);
        chromeDriver.get("https://www.google.com");
        System.out.println("Chrome Title: "+chromeDriver.getTitle());
        chromeDriver.quit();

    // Firefox Test
//    FirefoxOptions firefoxOptions = new FirefoxOptions();
//    WebDriver firefoxDriver = new RemoteWebDriver(
//            new URL("http://localhost:4444/wd/hub"), firefoxOptions);
//        firefoxDriver.get("https://www.google.com");
//        System.out.println("Firefox Title: "+firefoxDriver.getTitle());
//        firefoxDriver.quit();

}
}
