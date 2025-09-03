package reporters;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.google.common.base.Throwables.getStackTraceAsString;

public final class ScreenShotUtils {
    public static String getScreenShot() {
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        } catch (Exception oEx) {
            ExtentLogger.logFail("Error while getting screenshot. "+getStackTraceAsString(oEx));
            return "";
        }
    }
}

