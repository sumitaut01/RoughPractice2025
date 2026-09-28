package seleniummcp;

import org.openqa.selenium.By;

public class ClickTool {

    public String execute(String xpath) {

        DriverManager
                .getDriver()
                .findElement(By.xpath(xpath))
                .click();

        return "Clicked";
    }
}