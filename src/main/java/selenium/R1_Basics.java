package selenium;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.*;
import java.time.Duration;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class R1_Basics {


    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {

        ChromeOptions options = new ChromeOptions();
     //  options.addArguments("--disable-extensions");
// Point to a clean, custom profile
      //  String userProfile = "C://Users//inraus02//AppData//Local//Google//Chrome//User Data";
      //  options.addArguments("user-data-dir=" + userProfile);


        WebDriver driver = new ChromeDriver(options);
     //   driver.get("https://www.google.com");

        // driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();

        // driver.get("https://www.selenium.dev/");
      //  driver.get("https://uat01.gpp.corporate.ingrammicro.com:7443/#/home");

//        Set<Cookie> cookies = driver.manage().getCookies();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cookies.data"));
//        oos.writeObject(cookies);
//        oos.close();


       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // System.out.println(driver.findElement(lnkJoin).getText());
       // System.out.println("---------------------------------------");
      //  Thread.sleep(5000);
       // driver.findElements(lnkAll).forEach(ele-> System.out.println(ele.getText()));
    //    driver.quit();




        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cookies.data"));
        Set<Cookie> cookies = (Set<Cookie>) ois.readObject();
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }

        driver.get("https://uat01.gpp.corporate.ingrammicro.com:7443/#/home");
        //driver.navigate().refresh();
        Thread.sleep(10000);

        driver.quit();


        given()
                .auth().oauth2("eyJ0eXAiOiJKV1QiLCJh...")
                .get("https://graph.microsoft.com/v1.0/me")
                .then().log().all();
    }
}
