package reporters;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import java.util.List;



public class ExtentLogger {
    private ExtentLogger(){}

    public static void logPass(String message) {
   // if (getConfig().screenshot().toLowerCase().contains("all"))
        if ("all".toLowerCase().contains("all"))
    {
        addScreenShotInReport();
        ExtentManager.getExtentTest().log(Status.PASS, message);
        return;
    }
        ExtentManager.getExtentTest().log(Status.PASS, "<b  style=\"background-color:#e6fff7;\">"+message);
    }

    public static void addScreenShotInReport() {
        try {
            ExtentManager.getExtentTest().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getScreenShot()).build());
        }
        catch (Exception oEx){
            ExtentManager.getExtentTest().log(Status.INFO,"Error while capturing screenshot. "+oEx.getMessage());
        }
    }

    public static void logFail(String failMessage) {
        ExtentManager.getExtentTest().log(Status.FAIL, "<b style=\"background-color:#ffece6;\">"+failMessage);
    }

    public static void logWarn(String warnMessage) {
        ExtentManager.getExtentTest().log(Status.WARNING, "<b>"+warnMessage);
    }

    public static void logInfo(String infoMessage) {
        ExtentManager.getExtentTest().log(Status.INFO, infoMessage);
    }

    public static void logSkip(String skipMessage) {
        ExtentManager.getExtentTest().log(Status.SKIP, "<b>"+skipMessage);
    }

    public static void logInfoJson(String json) {
        ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }


    public static void logHeaders(List<Header> headersList) {
        String[][] arrayHeaders = headersList.stream().map(header -> new String[] {header.getName(), header.getValue()})
                .toArray(String[][] :: new);
        ExtentManager.getExtentTest().info(MarkupHelper.createTable(arrayHeaders));
    }

}
