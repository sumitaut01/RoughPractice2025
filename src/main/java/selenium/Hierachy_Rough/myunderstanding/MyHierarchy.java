package selenium.Hierachy_Rough.myunderstanding;

import selenium.mywebdriver.RemoteWebDriver;
import selenium.mywebdriver.SearchContext;
import selenium.mywebdriver.TakesScreenshot;
import selenium.mywebdriver.WebDriver;


interface ISearchContext {
    void findElement();
    void findElements();
}


 interface IJavaScriptExecutor{
    void executeScript();
 }

interface IWebDriver extends  ISearchContext{
    String getUrl();
}



interface IWebElement extends SearchContext, ITakesScreenShot {
    String click();
}

interface ITakesScreenShot{
    String getScreenShotAs();

}

class CRemoteWebDriver implements  ISearchContext,IWebDriver,IJavaScriptExecutor,ITakesScreenShot{
    @Override
    public void findElement() {

    }

    @Override
    public void findElements() {

    }

    @Override
    public void executeScript() {

    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getScreenShotAs() {
        return null;
    }
}

class CChromiumDriver extends CRemoteWebDriver {


}

class CChromeDriver extends CChromiumDriver{



}


public class MyHierarchy {
    public static void main(String[] args) {
        CRemoteWebDriver remoteWebDriver=new CRemoteWebDriver();
        IWebDriver webDriver=new CChromeDriver();
        System.out.println(((ITakesScreenShot) webDriver).getClass().descriptorString());
        ((ITakesScreenShot) webDriver).getScreenShotAs();

















    }

}







