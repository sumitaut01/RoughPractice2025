package reporters;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import org.openqa.selenium.edge.EdgeDriver;
//
//
//import java.io.IOException;
//import java.util.*;
//import static com.google.common.base.Throwables.getStackTraceAsString;
//
//public final class Driver {
//
//    private Driver() {
//    }
//
//
//
//    public static void initDriverForWeb() {
//        String config="local";
//        String browser="chrome";
//        WebDriver driver = null;
//        //Higher version of selenium , will not need WebDriverManager. Version>=4.6
//        //However Since we are uing mixed approach , setProperty is required. Else driver invocation failing
//        try {
//            /** DEBUG MODE Code
//             * debugmode will enable user to try code change from particular screen itself.
//             //1. Go to  C:\Users\inraus02>C:\Program Files\Google\Chrome\Application\
//             //2. Open command prompt in above and type below command . Note username(check for your user) and port 9222.
//             Port should match debuggerAddress in config file.
//             //command to be typed
//             //chrome.exe --remote-debugging-port=9222 --no-first-run --no-default-browser-check --user-data-dir="C:\Users\inraus02\AppData\Local\Google\Chrome\User Data"
//             **/
//            if (config.contains("debugmode")) {
//                if (browser.contains("chrome")) {
//                    WebDriverManager.chromedriver().setup();
//                    ChromeOptions opt = new ChromeOptions();
//                    opt.setExperimentalOption("debuggerAddress", getConfig().debugmodeipport());
//                    driver = new ChromeDriver(opt);
//                }
//            }
//
//            //local webdriver instance
//            else if (config.contains("local")) {
//                if (browser.contains("chrome")) {
//                    if (getConfig().webdrivermanager().toLowerCase().contains("true")) {
//                        WebDriverManager.chromedriver().setup();
//                        driver = new ChromeDriver(ChromeOptionsList.setlocalChromeOptions());
//                        //captureBearerToken((ChromeDriver) driver);//experimental line
//                    } else {
//                        System.setProperty("webdriver.chrome.driver", getConfig().chromedriverpath());
//                        driver = new ChromeDriver(ChromeOptionsList.setlocalChromeOptions());
//                    }
//                } else if (browser.contains("edge")) {
//                    if (getConfig().webdrivermanager().toLowerCase().contains("true")) {
//                        WebDriverManager.edgedriver().setup();
//                        driver = new EdgeDriver(EdgeOptionsList.setlocalEdgeOptions());
//                    } else {
//                        System.setProperty("webdriver.edge.driver", getConfig().edgedriverpath());
//                        driver = new EdgeDriver(EdgeOptionsList.setlocalEdgeOptions());
//                    }
//                } else {
//                    ExtentLogger.logFail("Invalid Browser name provided. Provided Name:" + getConfig().browser());
//                    // System.exit(1);
//                }
//            }
//            DriverManager.setDriver(driver);
//            loadURL();
//            //System.out.println(getBearerToken());
//        } catch (
//                Exception oEx) {
//            System.out.println("Error in loading browser " + getConfig().browser() + ".  Please check if the app is accessible. " + "<br>" + getStackTraceAsString(oEx));
//            ExtentLogger.logFail(getConfig().browser() + " Browser Invocation Failed. " + getStackTraceAsString(oEx));
//        }
//    }
//
//    /**
//     * Method used with multibrowser flag
//     *
//     * @param sBrowser This would come from testng xml parameters
//     */
//    public static void initDriverForWeb(String sBrowser) {
//        WebDriver driver = null;
//        //Higher version of selenium , will not need WebDriverManager. Version>=4.6
//        //However Since we are uing mixed approach , setProperty is required. Else driver invocation failing
//        try {
//
//            //local webdriver instance
//            if (config.contains("local")) {
//                if (sBrowser.toLowerCase().contains("chrome")) {
//                    if (getConfig().webdrivermanager().toLowerCase().contains("true")) {
//                        WebDriverManager.chromedriver().setup();
//                        driver = new ChromeDriver(ChromeOptionsList.setlocalChromeOptions());
//                        //captureBearerToken((ChromeDriver) driver);//experimental line
//
//                    } else {
//                        System.setProperty("webdriver.chrome.driver", getConfig().chromedriverpath());
//                        driver = new ChromeDriver(ChromeOptionsList.setlocalChromeOptions());
//                        // captureBearerToken((ChromeDriver) driver);//experimental line
//                    }
//                } else if (sBrowser.toLowerCase().contains("edge")) {
//                    if (getConfig().webdrivermanager().toLowerCase().contains("true")) {
//                        WebDriverManager.edgedriver().setup();
//                        driver = new EdgeDriver(EdgeOptionsList.setlocalEdgeOptions());
//                    } else {
//                        System.setProperty("webdriver.edge.driver", getConfig().edgedriverpath());
//                        driver = new EdgeDriver(EdgeOptionsList.setlocalEdgeOptions());
//                    }
//                } else {
//                    ExtentLogger.logFail("Invalid Browser name provided. Provided Name:" + getConfig().browser());
//                    // System.exit(1);
//                }
//            }
//            DriverManager.setDriver(driver);
//            loadURL();
//
//            // System.out.println(getBearerToken());
//        } catch (
//                Exception oEx) {
//            System.out.println("Error in loading browser " + getConfig().browser() + ".  Please check if the app is accessible. " + "<br>" + getStackTraceAsString(oEx));
//            ExtentLogger.logFail(getConfig().browser() + " Browser Invocation Failed. " + getStackTraceAsString(oEx));
//        }
//    }
//
//    public static void loadURL() {
//        //Skip url launch for debugmode
//        if (config.contains("debugmode")) return;
//        DriverManager.getDriver().get(getConfig().appurl());
//        DriverManager.getDriver().manage().window().maximize();
//        DriverManager.getDriver().manage().deleteAllCookies();
//        ExtentLogger.logInfo("Navigating to " + getConfig().appurl());
//    }
//
//    public static void quitDriver() {
//        if (!Objects.isNull(DriverManager.getDriver())) {
//            try {
//                DriverManager.getDriver().quit();
//            } catch (Exception oEx) {
//                oEx.printStackTrace();
//            }
//            try {
//                DriverManager.unload();
//            } catch (Exception oEx) {
//                oEx.printStackTrace();
//            }
//
//        }
//    }
//
//    //Experimental Feature to read AuthToken
//    // private static final AtomicReference<String> tokenHolder = new AtomicReference<>();
//
//    /**
//     * Initializes DevTools and captures Bearer token from request headers.
//     * @param driver The ChromeDriver instance
//     */
////    public static void captureBearerToken(ChromeDriver driver) {
////        DevTools devTools = driver.getDevTools();
////        devTools.createSession();
////
////        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
////
////        devTools.addListener(Network.requestWillBeSent(), request -> {
////            Headers headers = request.getRequest().getHeaders();
////            Object authHeader = headers.toJson().get("Authorization");
////            if (authHeader != null && authHeader.toString().startsWith("Bearer ")) {
////                tokenHolder.set(authHeader.toString());
////                System.out.println(" Bearer Token Captured: " + authHeader);
////            }
////        });
////    }
//
//    /**
//     * Returns the captured Bearer token.
//     *
//     * @return Bearer token as String
//     */
////    public static String getBearerToken() {
////        return tokenHolder.get();
////    }
//    public static void killExistingBrowsers() {
//        ArrayList<String> localOptions = (ArrayList<String>) ConfigFactory.getConfig().localedgeoptions();
//        System.out.println(localOptions);
//        if (localOptions.get(0).toLowerCase().contains("user-data-dir")) {
//            //means we are using profile and we want to kill existing edge windows
//            try {
//                Runtime.getRuntime().exec("taskkill /f /im msedge.exe");
//            } catch (IOException e) {
//                System.out.println("Error while Killing msedge.exe");
//            }
//        }
//
//
//    }
//}