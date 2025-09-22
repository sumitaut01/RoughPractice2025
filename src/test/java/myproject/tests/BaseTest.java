package myproject.tests;


import myproject.driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.initDriver();
    }


    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
