package factorydemo.factoryinseparateclass;

/*

What is @Factory

@Factory is used in TestNG to create instances of test classes dynamically.
Normally, TestNG creates 1 object per test class.
With @Factory, you can control how many objects are created and with what data.
So: it’s like a factory that produces test class objects.

 */
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

class LoginTest {

    private String browser;

    // constructor to accept parameter
    public LoginTest(String browser) {
        this.browser = browser;
    }

    @Test
    public void testLogin() {
        System.out.println("Running login test on browser: " + browser);
        // here you would open WebDriver for respective browser
    }
}

//notice is testng, we are mentioning this class only
// if  only method we had added, then we could have used only the class name
 public class TestFactory {
    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new LoginTest("Chrome"),
                new LoginTest("Firefox"),
                new LoginTest("Edge")
        };
    }
}

