package selenium;

import org.openqa.selenium.SearchContext;

public interface myWebDriver extends SearchContext {
	public void get(String url);
	public void getCurrenturl(String url);
    public void getPageSource();
    public interface Options{
    	public void addCookie(String cookie);
    	
    }
}
