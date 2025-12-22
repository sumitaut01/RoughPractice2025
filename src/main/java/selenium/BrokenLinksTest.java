package selenium;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenLinksTest {

    @Test
    public void verifyBrokenLinks() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rediff.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            // Skip empty or javascript links
            if (url == null || url.isEmpty() || url.startsWith("javascript")) {
                continue;
            }

            try {
                Response response = RestAssured
                        .given()
                        .header("User-Agent", "Mozilla/5.0")
                        .header("Accept", "*/*")
                        .relaxedHTTPSValidation()
                        .when()
                        //
                // .get(url); //try head also
                        .head(url);

                int statusCode = response.getStatusCode();

                if(statusCode==200){
                    System.out.println("ok link=>"+url);
                }

                if (statusCode >= 400) {
                    System.out.println("❌ Broken link: " + url +
                                       " | Status: " + statusCode);
                } else {
                    System.out.println("✅ Valid link: " + url);
                }

            } catch (Exception e) {
                System.out.println("❌ Exception for link: " + url);
            }
        }

        driver.quit();
    }
}
