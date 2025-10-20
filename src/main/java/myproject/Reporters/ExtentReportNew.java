package myproject.Reporters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNew {
    static ExtentReports reports=new ExtentReports();
    static ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("Report.html");

    public static void init() {
        reports.attachReporter(extentSparkReporter);
    }

    public static void createTest(String sTestName){
        ExtentTest test=reports.createTest(sTestName);
        ExtentManager.setExtentTest(test);

    }

    public static void flush(){
        reports.flush();
    }

}
