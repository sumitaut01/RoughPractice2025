package selenium.misc;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.network.Network;


import java.util.Optional;
import java.util.Set;

public class DevToolsDemo{
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();

        // Create DevTools session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // Enable network domain
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Listen to network requests
        devTools.addListener(Network.requestWillBeSent(), request ->
                System.out.println("➡️ Request URL: " + request.getRequest().getUrl())
        );

        driver.get("https://uat01.gpp.corporate.ingrammicro.com:7443/index.html"); // or any other API hitting site
        Set<Cookie> allCookies = driver.manage().getCookies();

        System.out.println(allCookies);
        driver.quit();
    }
}
