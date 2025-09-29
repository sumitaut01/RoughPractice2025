//package com.utils.seleniumutils;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//
//import java.io.File;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.function.Function;
//
//import static com.config.FrameWorkConstants.*;
//import static com.google.common.base.Throwables.getStackTraceAsString;
//
//public final class WebWaits {
//
//    private WebWaits() {
//    }
//
//    private static Duration getWaitType(WaitType waitType) {
//        Duration waitTime = null;
//
//
//        try {
//            switch (waitType) {
//                case EXTRASMALL:
//                    waitTime = EXTRASMALLWAIT;
//                    break;
//                case SMALL:
//                    waitTime = SMALLWAIT;
//                    break;
//                case MEDIUM:
//                    waitTime = MEDIUMWAIT;
//                    break;
//                case LARGE:
//                    waitTime = LARGEWAIT;
//                    break;
//                case EXTRALARGE:
//                    waitTime = EXTRALARGEWAIT;
//                    break;
//                case IMPLICIT:
//                    waitTime = IMPLICITWAITTIMEOUT;
//                    break;
//                case EXPLICIT:
//                    waitTime = EXPLICITWAITTIMEOUT;
//                    break;
//                case PAGELOAD:
//                    waitTime = PAGELOADTIMEOUT;
//                    break;
//                default:
//                    throw new IllegalArgumentException("Undefined Wait Type.");
//            }
//        } catch (Exception var4) {
//            Assert.fail("Failed While getting wait type" + waitType + " "+getStackTraceAsString(var4));
//        }
//        return waitTime;
//
//
//    }
//
//    public static void waitForElementToBeClickable(By locator, WaitType waitType) {
//        try {
//            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), getWaitType(waitType));
//            wait.until(ExpectedConditions.elementToBeClickable(locator));
//        } catch (Exception var5) {
//            var5.getStackTrace();
//            Assert.fail("Failed Waiting For Element ::" + locator + "  To Be Clickable."+  " "+getStackTraceAsString(var5));
//        }
//
//    }
//
//    public static void waitForElementToBeClickable(WebElement element, WaitType waitType) {
//        try {
//
//            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), getWaitType(waitType));
//            wait.until(ExpectedConditions.elementToBeClickable(element));
//        } catch (Exception var5) {
//            Assert.fail("Failed Waiting For Element ::" + element.toString() + "  To Be Clickable. "+ " "+getStackTraceAsString(var5));
//        }
//
//    }
//
//    public static void waitForElementToBePresent(By locator, WaitType waitType) {
//        try {
//
//            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), getWaitType(waitType));
//            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//        } catch (Exception var5) {
//            Assert.fail("Failed Waiting For Element ::" + locator + "  To Be Present. "+ " "+getStackTraceAsString(var5));
//        }
//
//    }
//
//    public static void waitForElementToBeVisible(By locator, WaitType waitType) {
//        try {
//
//            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), getWaitType(waitType));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        } catch (Exception var5) {
//            Assert.fail("Failed Waiting For Element ::" + locator + "  To Be Visible."+ " "+getStackTraceAsString(var5));
//        }
//
//    }
//
//    public static void waitForElementToBeInvisible(By locator, WaitType waitType) {
//        boolean result = false;
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), getWaitType(waitType));
//            result = (Boolean) wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//            if (!result) {
//                throw new TimeoutException();
//            }
//        } catch (TimeoutException var6) {
//            Assert.fail("Timeout Exception :: " + var6.getMessage() + " while waiting For Element :: " + locator + "  To Be Invisible. "+ " "+getStackTraceAsString(var6));
//        } catch (Exception var7) {
//            //ExceptionHandler.handle(var7, "Failed Waiting For Element ::" + locator + "  To Be Invisible");
//        }
//
//    }
//
//    public static void waitForPageload(WaitType waitType) {
//        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                String result= (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
//               //System.out.println("Page load status"+result);
//                return ((JavascriptExecutor) driver).executeScript("return document.readyState", new Object[0]).toString().equals("complete");
//            }
//        };
//
//        try {
//            Thread.sleep(500L);
//            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), getWaitType(waitType));
//            wait.until(expectation);
//        } catch (Throwable var4) {
//
//            Assert.fail("Timeout waiting for Page Load Request to complete.  "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static void waitForElementToBeEnabled(final By locator, WaitType waitType) {
//        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return driver.findElement(locator).isEnabled();
//            }
//        };
//
//        try {
//            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), getWaitType(waitType));
//            wait.until(expectation);
//        } catch (Throwable var5) {
//            Assert.fail("Timeout waiting for Page Load Request to complete ."+ " "+getStackTraceAsString(var5));
//        }
//
//    }
//
//    public static void fluentlyWaitForElementToBeEnabled(final By locator, WaitType waitType) {
//        try {
//            FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
//            wait.withTimeout(getWaitType(waitType)).pollingEvery(Duration.ofSeconds(1L)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).until(new Function<WebDriver, Boolean>() {
//                public Boolean apply(WebDriver d) {
//                    return d.findElement(locator).isEnabled();
//                }
//            });
//        } catch (TimeoutException var4) {
//            Assert.fail("Element :" + locator + " is not enabled within -" + getWaitType(waitType) + " seconds. "+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static void fluentlyWaitForElementToBeDisplayed(final By locator, WaitType waitType) {
//
//        try {
//            FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
//            wait.withTimeout(getWaitType(waitType))
//            .pollingEvery(Duration.ofSeconds(1L))
//            .ignoring(NoSuchElementException.class)
//            .ignoring(StaleElementReferenceException.class)
//            .until(new Function<WebDriver, Boolean>() {
//                public Boolean apply(WebDriver d) {
//                    WebElement element = d.findElement(locator);
//                    return element.isDisplayed();
//                }
//            });
//        } catch (TimeoutException var4) {
//            Assert.fail("Element : " + locator + " is not displayed within -" + getWaitType(waitType) + " seconds."+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static void fluentlyWaitForTextToBeDisplayedInElement(final By locator, String text, WaitType waitType) {
//        final String txt = text;
//
//
//        try {
//            FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
//            wait.withTimeout(getWaitType(waitType)).pollingEvery(Duration.ofSeconds(1L)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).until(new Function<WebDriver, Boolean>() {
//                public Boolean apply(WebDriver d) {
//                    WebElement element = d.findElement(locator);
//                    ExpectedConditions.textToBePresentInElement(element, txt);
//                    return element.isDisplayed();
//                }
//            });
//        } catch (TimeoutException var6) {
//            Assert.fail("Text - " + text + " for the Element : " + locator + " is not displayed within -" + getWaitType(waitType) + " seconds. "+ " "+getStackTraceAsString(var6));
//        }
//
//    }
//
//    public static void fluentlyWaitForElementToBeDisabled(final By locator, WaitType waitType) {
//        try {
//            FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
//
//            wait.withTimeout(getWaitType(waitType)).pollingEvery(Duration.ofSeconds(1L)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).until(new Function<WebDriver, Boolean>() {
//                public Boolean apply(WebDriver d) {
//                    WebElement element = d.findElement(locator);
//                    return !element.isEnabled();
//                }
//            });
//        } catch (TimeoutException var4) {
//            Assert.fail("Element : " + locator + " is not disabled within -" + getWaitType(waitType) + " seconds. "+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static void waitForBrowserToOpenNewTab(WaitType waitType) {
//        try {
//            FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
//
//            wait.withTimeout(getWaitType(waitType)).pollingEvery(Duration.ofSeconds(1L)).until(new Function<WebDriver, Boolean>() {
//                public Boolean apply(WebDriver d) {
//                    ArrayList<String> tabs = new ArrayList<>(d.getWindowHandles());
//                    return tabs.size() > 1;
//                }
//            });
//        } catch (TimeoutException var3) {
//            Assert.fail("Timeout of -" + getWaitType(waitType) + " seconds was reached before the browser open new tab. "+ " "+getStackTraceAsString(var3));
//        }
//
//    }
//
//    public static void waitForFileToExist(final String filePath, WaitType waitType) {
//        try {
//            FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
//            wait.withTimeout(getWaitType(waitType)).
//                    pollingEvery(Duration.ofSeconds(1L)).
//                    until(new Function<WebDriver, Boolean>() {
//                        public Boolean apply(WebDriver d) {
//                            File f = new File(filePath);
//                            if (f.exists()) {
//                                System.out.println("File found at " + filePath + ". ");
//                                return true;
//                            } else {
//                                return false;
//                            }
//                        }
//                    });
//        } catch (TimeoutException var4) {
//            Assert.fail("The timeout of " + getWaitType(waitType) + " seconds was reached before the file at " + filePath + " could be found. "+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
////    public static void waitForUrlToBeAccessible(final String url, WaitType waitType) {
////        try {
////            (new FluentWait(  DriverManager.getDriver())).withTimeout(getWaitType(waitType)).pollingEvery(Duration.ofSeconds(1L)).until(new Function<WebDriver, Boolean>() {
////                public Boolean apply(WebDriver d) {
////                    WebActions actions = new WebActions();
////                    return actions.urlIsAccessible(url);
////                }
////            });
////        } catch (TimeoutException var4) {
////            Assert.fail("Timeout occured after " + this.getWaitType(waitType) + " seconds waiting for the URL to be accessible.");
////        }
////
////    }
//
////    public static void waitForAngularLoad(WaitType waitType) {
////        final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length";
////        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
////            public Boolean apply(WebDriver driver) {
////                return ((JavascriptExecutor)driver).executeScript(angularReadyScript, new Object[0]).toString().equals("0");
////            }
////        };
////
////        try {
////            Thread.sleep(500L);
////            WebDriverWait wait = new WebDriverWait(  DriverManager.getDriver(), getWaitType(waitType));
////            wait.until(expectation);
////        } catch (Throwable var5) {
////            Assert.fail("Timeout waiting for Angular Load to complete.");
////        }
////
////    }
//}