package myproject.tests;


import com.aventstack.extentreports.ExtentReports;
import demo.threadlocal.DriverManager;
import myproject.Reporters.ExtentReportNew;
import myproject.driverfactory.DriverFactory;
import org.apache.http.io.SessionOutputBuffer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import reporters.ExtentLogger;

import java.lang.reflect.Method;

public class BaseTest {
    WebDriver driver;




    @BeforeSuite
    public void setupExtent(){
        ExtentReportNew.init();
    }

    @AfterSuite
    public void flushExtent(){
        ExtentReportNew.flush();
    }

    @BeforeMethod
    public void setUp(Method m) throws Exception {
        driver = DriverFactory.initDriver();
        DriverManager.setDriver(driver);
        ExtentReportNew.createTest(m.getName());


        System.out.println("-------------------------------");

        String env = System.getenv("runmode");
        System.out.println("Running in environment: " + env);

        System.out.println("-------------------------------");
    }


    @AfterMethod
    public void tearDown() {
        DriverManager.getDriver().quit();
        DriverManager.remove();


    }
}
