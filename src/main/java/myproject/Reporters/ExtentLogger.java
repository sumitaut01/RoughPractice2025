package myproject.Reporters;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentLogger {

    public static void logInfo(String details){
        ExtentManager.getExtentTest().log(Status.INFO, details);
    }

    public static void logPass(String details){
        ExtentManager.getExtentTest().log(Status.PASS, details);
    }

    public static void logFail(String details){
        ExtentManager.getExtentTest().log(Status.PASS, details);
    }


}
