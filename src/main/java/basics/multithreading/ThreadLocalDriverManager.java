//package basics.multithreading;
//
////What is ThreadLocal?
////ThreadLocal provides thread-local variables, meaning:
////Each thread that accesses the variable gets its own, independent copy.
////It’s like a Map<Thread, Object> behind the scenes.
//
////Why is ThreadLocal Used?
////Problem	Without ThreadLocal	With ThreadLocal
////Shared WebDriver object	Tests interfere in parallel runs	Each thread gets its own WebDriver
////Logging	Mixed log output from threads	Isolated logs per thread
////Data handling	Variables overwritten by other
//
//
//
//
//import Programs.ChromeDriver;
//import org.openqa.selenium.WebDriver;
//
//
//
//public class ThreadLocalDriverManager {
//
//    // Thread-safe WebDriver storage
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//
//    public static void setDriver(WebDriver driverInstance) {
//        driver.set(driverInstance);
//    }
//
//    public static void unload() {
//        driver.remove(); // cleanup to avoid memory leak
//    }
//}
//
//
//class DriverFactory {
//
//    public static void initDriver() {
//          // or FirefoxDriver
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        DriverManager.setDriver(driver);
//    }
//
//    public static void quitDriver() {
//        if (DriverManager.getDriver() != null) {
//            DriverManager.getDriver().quit();
//            DriverManager.unload(); // cleanup
//        }
//    }
//}
//
//
