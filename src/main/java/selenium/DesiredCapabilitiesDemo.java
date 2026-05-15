package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/*

DesiredCapabilities was historically used in Selenium to define browser configuration and driver settings before starting a session.

Examples:

browser name
browser version
platform
headless mode
SSL handling
proxy
Chrome/Firefox-specific options

Example from older Selenium code:

DesiredCapabilities cap = new DesiredCapabilities();
cap.setBrowserName("chrome");
cap.setCapability("acceptInsecureCerts", true);

WebDriver driver = new ChromeDriver(cap);
 */
public class DesiredCapabilitiesDemo {

    @Test
    public void Demo(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setCapability("acceptInsecureCerts", true);
        //WebDriver driver = new ChromeDriver(cap);
    }
}

/*

DesiredCapabilities was historically used in Selenium to define browser configuration and driver settings before starting a session.

Examples:

browser name
browser version
platform
headless mode
SSL handling
proxy
Chrome/Firefox-specific options

Example from older Selenium code:

DesiredCapabilities cap = new DesiredCapabilities();
cap.setBrowserName("chrome");
cap.setCapability("acceptInsecureCerts", true);

WebDriver driver = new ChromeDriver(cap);
Do we still use DesiredCapabilities?

Mostly NO in modern Selenium 4.

Now the recommended approach is:

ChromeOptions
FirefoxOptions
EdgeOptions

because these classes already implement capabilities internally.

Modern Selenium 4 way
Chrome example
ChromeOptions options = new ChromeOptions();

options.addArguments("--start-maximized");
options.setAcceptInsecureCerts(true);

WebDriver driver = new ChromeDriver(options);
Why Selenium moved away from DesiredCapabilities

Older Selenium had:

JSON Wire Protocol
browser-specific handling

Selenium 4 uses:

W3C WebDriver standard

So browser option classes became the preferred standard.

But capabilities still exist internally

Even today:

ChromeOptions options = new ChromeOptions();

is actually also a capabilities object.

You can still do:

options.setCapability("customKey", "value");

So capabilities concept still exists — just not usually through DesiredCapabilities.

When capabilities are still commonly used
1. Selenium Grid
ChromeOptions options = new ChromeOptions();
options.setBrowserVersion("124");
options.setPlatformName("WINDOWS");
2. Cloud providers

Like:

BrowserStack
Sauce Labs
LambdaTest

Example:

ChromeOptions options = new ChromeOptions();

options.setCapability("browserVersion", "latest");
options.setCapability("LT:Options", Map.of(
    "project", "Demo"
));
3. Custom driver configuration

Example:

download directory
logging prefs
mobile emulation
experimental options
Interview-style understanding

Think of it like this:

Old Selenium	Modern Selenium
DesiredCapabilities	ChromeOptions / FirefoxOptions
Generic capabilities object	Browser-specific options object
Selenium 2/3 style	Selenium 4 style
Important interview point

You may still see old frameworks using:

DesiredCapabilities

because:

many enterprise frameworks are old
Grid setups used them heavily
backward compatibility exists

But for new automation frameworks:

prefer ChromeOptions
prefer browser option classes
Example comparison
OLD
DesiredCapabilities cap = DesiredCapabilities.chrome();
cap.setCapability("acceptInsecureCerts", true);

WebDriver driver = new ChromeDriver(cap);
NEW
ChromeOptions options = new ChromeOptions();
options.setAcceptInsecureCerts(true);

WebDriver driver = new ChromeDriver(options);

The new version is the recommended one.
 */