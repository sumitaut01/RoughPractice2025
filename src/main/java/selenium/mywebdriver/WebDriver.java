package selenium.mywebdriver;

public interface WebDriver extends SearchContext {
	
	
	public void get(String url);
	public void getCurrenturl(String url);
    public void getPageSource();
    
    
    public interface Options{
    	public void addCookie(String cookie);
    	
    }
}
