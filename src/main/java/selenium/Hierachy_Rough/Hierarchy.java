package selenium.Hierachy_Rough;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Hierarchy {


    public static void main(String[] args) {

        SearchContext context;//public interface SearchContext

        WebDriver driver;//public interface WebDriver
        /*
        public interface WebDriver extends org.openqa.selenium.SearchContext
         */
        JavascriptExecutor javascriptExecutor;//public interface JavascriptExecutor

        TakesScreenshot takesScreenshot;//public interface TakesScreenshot

        WebElement webElement;//public interface WebElement
        /*
        public interface WebElement extends org.openqa.selenium.SearchContext, org.openqa.selenium.TakesScreenshot
         */

        RemoteWebDriver remoteWebDriver;// public class RemoteWebDriver
        /*
        public class RemoteWebDriver
               implements org.openqa.selenium.WebDriver,
           org.openqa.selenium.JavascriptExecutor,
           org.openqa.selenium.HasCapabilities,
           org.openqa.selenium.HasDownloads,
           org.openqa.selenium.federatedcredentialmanagement.HasFederatedCredentialManagement,
           org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator,
           org.openqa.selenium.interactions.Interactive,
           org.openqa.selenium.PrintsPage,
           org.openqa.selenium.TakesScreenshot
         */

        ChromiumDriver chromiumDriver;//public class ChromiumDriver
        /*
        public class ChromiumDriver extends org.openqa.selenium.remote.RemoteWebDriver
implements org.openqa.selenium.HasAuthentication,
           org.openqa.selenium.bidi.HasBiDi,
           org.openqa.selenium.chromium.HasCasting,
           org.openqa.selenium.chromium.HasCdp,
           org.openqa.selenium.devtools.HasDevTools,
           org.openqa.selenium.chromium.HasLaunchApp,
           org.openqa.selenium.logging.HasLogEvents,
           org.openqa.selenium.chromium.HasNetworkConditions,
           org.openqa.selenium.chromium.HasPermissions,
           org.openqa.selenium.html5.LocationContext,
           org.openqa.selenium.html5.WebStorage
         */
        ChromeDriver chromeDriver;//public class ChromeDriver
        /*
          public class ChromeDriver extends org.openqa.selenium.chromium.ChromiumDriver
         */

        Wait<String> wait;//public interface Wait<F>

        FluentWait<String> fluentWait;//public class FluentWait<T>
        /*
        public class FluentWait<T> implements org.openqa.selenium.support.ui.Wait<T>
         */

        Actions actions;//public class Actions

        Action action;//public interface Action

        Alert alert;//public interface Alert

        Select select;
        //public class Select
        //implements org.openqa.selenium.support.ui.ISelect, org.openqa.selenium.WrapsElement






    }
}
