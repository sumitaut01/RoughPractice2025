package seleniummcp;

public class OpenUrlTool {

    public String execute(String url) {

        DriverManager
                .getDriver()
                .get(url);

        return "Opened : " + url;
    }
}