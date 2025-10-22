package selenium;
//PageFactory is the mechanism that makes @FindBy work.
//
//You can think of it this way:
//@FindBy defines what to locate,
//and PageFactory does the work of locating it and injecting the element into your page class.
//
//🔹 Step 1: Relationship in one line
//@FindBy → used for element declaration
//PageFactory → used for element initialization
//
//
//Both come from the same package:
//
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//🔹 Step 2: How they work together
//Example 👇
//public class LoginPage {
//
//    @FindBy(id = "username")
//    private WebElement usernameField;
//
//    @FindBy(id = "password")
//    private WebElement passwordField;
//
//    @FindBy(id = "loginBtn")
//    private WebElement loginButton;
//
//    public LoginPage(WebDriver driver) {
//        // This line initializes all @FindBy annotated elements
//        PageFactory.initElements(driver, this);
//    }
//
//    public void login(String user, String pass) {
//        usernameField.sendKeys(user);
//        passwordField.sendKeys(pass);
//        loginButton.click();
//    }
//}
//
//🔹 Step 3: What happens internally
//
//When you call:
//
//PageFactory.initElements(driver, this);
//
//
//Here’s what Selenium does under the hood:
//
//It scans your class (this) for all @FindBy annotations.
//
//For each annotated field, it creates a proxy object (not the actual WebElement yet).
//
//When you use that WebElement for the first time (e.g., .click()),
//the proxy calls driver.findElement(By...) at that moment (lazy initialization).
//
//The found element is cached (if needed) and interacted with.
//
//✅ So it enables lazy loading and clean separation of locators from logic.
//
//🔹 Step 4: You can technically use one without the other
//Case	Works?	Explanation
//@FindBy without PageFactory	❌ No	The fields never get initialized
//PageFactory without @FindBy	✅ Yes (but pointless)	You can still init elements manually
//Both together	✅ Yes	Standard POM style
//
//Example that won’t work:
//
//public class LoginPage {
//    @FindBy(id = "username")
//    WebElement username;
//}

//Without:
//PageFactory.initElements(driver, this);
//👉 username will stay null, because no initialization happened.
//
//🔹 Step 5: Visual Analogy
//
//Think of it like this:
//Component	Role
//@FindBy	“Blueprint” → tells where to find an element
//PageFactory	“Builder” → scans the blueprints and builds actual element proxies
//
//So one declares what to locate,
//the other materializes those declarations into usable WebElements.
//
//🔹 Step 6: What changed in Selenium 4+
//PageFactory and @FindBy are still supported and not deprecated,
//but Selenium encourages moving toward constructor-based By locators instead.
//
//For example:
//public class LoginPage {
//    private final WebDriver driver;
//    private final By username = By.id("username");
//    private final By password = By.id("password");
//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//    }
//    public void login(String user, String pass) {
//        driver.findElement(username).sendKeys(user);
//        driver.findElement(password).sendKeys(pass);
//    }
//}
//
//✅ No reflection, faster, works with modern frameworks.
//
//✅ TL;DR Summary
//Concept	Description
//@FindBy	Annotation to declare locators
//PageFactory	Utility to initialize those annotated elements
//Relationship	PageFactory makes @FindBy elements usable (lazy-loaded proxies)
//Required Together?	Yes, for automatic element initialization
//Deprecation	❌ Neither are deprecated
//Modern alternative	Use By locators in constructor (no PageFactory)
//
//In short:
//@FindBy says "what to find",
//PageFactory says "I’ll find it for you when you need it."
public class R_XPageFactory {
}
