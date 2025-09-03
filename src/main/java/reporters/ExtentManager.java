package reporters;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.util.Objects;

public final class ExtentManager {

    private ExtentManager() {
    }

    private static final ThreadLocal<ExtentTest> EXTENTTEST_THREAD_LOCAL = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return EXTENTTEST_THREAD_LOCAL.get();

    }


    public static void setExtentTest(ExtentTest test) {
        EXTENTTEST_THREAD_LOCAL.set(test);
    }

    public static void unload() {

        try{
        if (!Objects.isNull(EXTENTTEST_THREAD_LOCAL)) {
            //ExtentManager.getExtentTest().log(Status.INFO, "Test Finished", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getScreenShot()).build());
            ExtentManager.getExtentTest().log(Status.INFO, "Test Finished");
            EXTENTTEST_THREAD_LOCAL.remove();
        }
        }
        catch (Exception oEx){
            ExtentManager.getExtentTest().log(Status.FAIL, "Test Finished with Exception=>"+ oEx.fillInStackTrace().getLocalizedMessage());
            EXTENTTEST_THREAD_LOCAL.remove();
        }

    }
}
