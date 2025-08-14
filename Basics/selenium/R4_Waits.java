package selenium;

import groovy.transform.ASTTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class R4_Waits {


    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();


        driver.get("https://www.selenium.dev/");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("somr random text"));

        driver.quit();
    }
}


//Exception in thread "main" org.openqa.selenium.TimeoutException: Expected condition failed: waiting for title to be "somr random text". Current title: "Selenium" (tried for 10 second(s) with 500 milliseconds interval)
//Build info: version: '4.34.0', revision: '707dcb4246*'
//System info: os.name: 'Windows 11', os.arch: 'amd64', os.version: '10.0', java.version: '21.0.3'
//Driver info: org.openqa.selenium.chrome.ChromeDriver
//Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 137.0.7151.69, chrome: {chromedriverVersion: 137.0.7151.119 (e0ac9d12dff..., userDataDir: C:\Users\inraus02\AppData\L...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:49776}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:49776/devtoo..., se:cdpVersion: 137.0.7151.69, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
//Session ID: 7c60d762447c397258ec6ce5ce4dcfb9
//    at org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:84)
//    at org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:228)
//    at selenium.R4_Waits.main(R4_Waits.java:23)
//
//    Process finished with exit code 1

