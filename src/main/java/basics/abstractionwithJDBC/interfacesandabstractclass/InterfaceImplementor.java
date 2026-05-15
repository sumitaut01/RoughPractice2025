package basics.abstractionwithJDBC.interfacesandabstractclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterfaceImplementor implements  myDriver {


    public static void main(String[] args) {


    }

    @Override
    public WebDriver getDriver() {
        return new ChromeDriver();
    }
}
