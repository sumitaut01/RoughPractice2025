package zzRough;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.*;
import java.sql.DriverManager;
import java.time.Duration;


public class RoghDec28 {
    @Test
    public void Demo() {

        WebDriver driver = null;
        System.out.println(Browser.valueOf("CHROME"));
        Browser browser = Browser.valueOf("CHROME");
        System.out.println(browser);

        switch (browser) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
        DriverManagerX.setDriver(driver);

        DriverManagerX.getDriver().get("http://www.rediff.com");
        DriverManagerX.getDriver().close();
        DriverManagerX.getDriver().quit();
        DriverManagerX.remove();
    }


    @Test
    public void Rough2() {
        WebDriver driver = new ChromeDriver();

        String url = "https://testautomationpractice.blogspot.com/";
        JavascriptExecutor javascriptExecutor;

        driver.get(url);
        WebElement ele = driver.findElement(By.xpath("//input[@id='name']"));
        javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle());

        javascriptExecutor.executeScript("arguments[0].value = arguments[1];", ele, "sumit");
        String value=(String) javascriptExecutor.executeScript("return arguments[0].value;", ele);
        System.out.println(value);
        driver.quit();
    }


    @Test
    public void Rough() throws SQLException {
        Connection connection=DriverManager.getConnection("", "", "");
        String stm="select * from emp where id=?";
        PreparedStatement ps=connection.prepareStatement(stm);
        ps.setString(1, "sumit");
          ResultSet set =ps.executeQuery();
        String stm2="insert into studenet(emp,name) values(1,'sumit')";
        PreparedStatement ps2=connection.prepareStatement(stm2);
        ps2.executeQuery();
    }
}


class DriverManagerX {
    static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManagerX.driver.set(driver);
    }


    public static void remove() {
        driver.remove();
    }
}


enum Browser {
    CHROME,
    FIREFOX
}



interface  dProvider{
    WebDriver getDriver(String browser);

}


class  dChromeimplementer implements dProvider{
    @Override
    public WebDriver getDriver(String browser) {
        return new ChromeDriver();
    }
}


class  dFirefoximplementer implements dProvider{
    @Override
    public WebDriver getDriver(String browser) {
        return new FirefoxDriver();
    }
}



class DriverFactorydd {

    private  DriverFactorydd(){};
    static WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            new ChromeDriver();
        } else {
            new FirefoxDriver();
        }
        return  null;
    }
}



