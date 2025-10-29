package selenium.waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class R1_FlunentWait {
    public static void main(String[] args) throws InterruptedException {

        String s="s";
        FluentWait<String> fluentWait=new FluentWait<String>(s);
        fluentWait.ignoring(Exception.class)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(10))
                .withMessage("waiting---");

        for(int i=0;i<5;i++){
            s=s+i;
            fluentWait.until(st->st.length()>5);
            Thread.sleep(1);
        }
        //Exception in thread "main" org.openqa.selenium.TimeoutException: Expected condition failed: waiting--- (tried for 10 second(s) with 1000 milliseconds interval)
        //Build info: version: '4.34.0', revision: '707dcb4246*'
        //System info: os.name: 'Windows 11', os.arch: 'amd64', os.version: '10.0', java.version: '21.0.2'
        //Driver info: driver.version: unknown
        //	at org.openqa.selenium.support.ui.FluentWait.timeoutException(FluentWait.java:265)
        //	at org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:228)
        //	at selenium.waits.R1_FlunentWait.main(R1_FlunentWait.java:21)






    }
}

//Generic Interface
//public interface Wait<F> {
//    <T> T until(Function<? super F, T> isTrue);
//}




