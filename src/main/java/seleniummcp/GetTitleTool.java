package seleniummcp;

public class GetTitleTool {

    public String execute() {

        return DriverManager
                .getDriver()
                .getTitle();
    }
}