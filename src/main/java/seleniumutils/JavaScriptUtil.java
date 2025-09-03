//package com.utils.seleniumutils;
//import com.driver.DriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//
//public class JavaScriptUtil {
//    public static void flash(WebElement element) {
//        String bgcolor = element.getCssValue("backgroundColor");
//        for (int i = 0; i < 2; i++) {
//            changeColor("rgb(0,200,0)", element);// 1
//            changeColor(bgcolor, element);// 2
//        }
//    }
//
//    private static void changeColor(String color, WebElement element) {
//        JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
//        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
//
//        try {
//            Thread.sleep(2);
//        } catch (InterruptedException e) {
//        }
//    }
//
//    public static String getTitleByJS() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        return js.executeScript("return document.title;").toString();
//    }
//
//    public static void goBackByJS() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("history.go(-1)");
//    }
//
//    public static void goForwardByJS() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("history.go(1)");
//    }
//
//    public void refreshBrowserByJS() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("history.go(0);");
//    }
//
//    public static void generateAlert(String message) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("alert('" + message + "')");
//    }
//
//    public static void generateConfirmPopUp(String message) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("confirm('" + message + "')");
//    }
//
//    public static String getPageInnerText() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        return js.executeScript("return document.documentElement.innerText;").toString();
//    }
//
//    public static void clickElementByJS(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("arguments[0].click();", element);
//    }
//
//    public static void clickElementUsingByLocatorJS(By byLocator) {
//        WebElement ele=DriverManager.getDriver().findElement(byLocator);
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("arguments[0].click();", ele);
//    }
//
//    public static void sendKeysUsingWithId(String id, String value) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
//        //document.getElementById('input-email').value ='tom@gmail.com'
//    }
//
//    public static void sendKeys(By locator, String value) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        WebElement element = DriverManager.getDriver().findElement(locator);
//       js.executeScript("arguments[0].value = arguments[1];", element, value);
//    }
//
//    public static void scrollPageDown() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//    }
//
//    public static void scrollPageDown(String height) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("window.scrollTo(0, '" + height + "')");
//    }
//
//    public static void scrollPageUp() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
//    }
//
//    public static void scrollPageDownMiddlepage() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
//    }
//
//    public static void scrollIntoView(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("arguments[0].scrollIntoView(false);", element);
//    }
//
//    public static void drawBorder(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        js.executeScript("arguments[0].style.border='3px solid red'", element);
//    }
//
//    public static void setAttribute(By by,String sAttributeName,String sAttributeValue) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        WebElement element = DriverManager.getDriver().findElement(by);
//        js.executeScript("arguments[0].value = '';", element);
//        js.executeScript("arguments[0].setAttribute('"+sAttributeName+"', '"+sAttributeValue+"')",element);
//    }
//
//    public static WebElement getShadowRoot(WebElement shadowHost) {
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        return (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
//    }
//
////    JavascriptExecutor js = (JavascriptExecutor) driver;
////    WebElement element = driver.findElement(By.linkText("Click ME"));
////js.executeScript("arguments[0].setAttribute('attr', '10')",element);
//
//}