package selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRough {

    static ExtentReports extentReports;

    static ExtentSparkReporter extentSparkReporter;


    static ExtentTest test;


    public static void main(String[] args) {
        extentReports=new ExtentReports();
        extentSparkReporter=new ExtentSparkReporter("myExtent.html");
        extentReports.attachReporter(extentSparkReporter);
        test = extentReports.createTest("mytest");
        test.log(Status.INFO, "someinfor");
        extentReports.flush();
    }


}
