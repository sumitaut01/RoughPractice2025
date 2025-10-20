package myproject.listeners;

import myproject.Reporters.ExtentLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyProjectListener implements ITestListener {

     public void onTestStart(ITestResult result) {

         System.out.println("Test has been started: onTestStart");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test has been Sucess: onTestSuccess");
        ExtentLogger.logPass("Test has been Sucess: onTestSuccess");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test has been failed: onTestFailure");
        ExtentLogger.logFail("Test has been failed: onTestFailure");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test has been Skipped: onTestStart");
    }

     public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

     public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

     public void onStart(ITestContext context) {

         System.out.println("Test has been started: onStart");
    }

     public void onFinish(ITestContext context) {
         System.out.println("Test has been finished: onFinish");
    }
    
}
