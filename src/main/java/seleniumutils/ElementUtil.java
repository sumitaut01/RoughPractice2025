//package com.utils.seleniumutils;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.config.ConfigFactory;
//import com.driver.DriverManager;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.*;
//
//
//public class ElementUtil {
//    public static WebElement getElement(By locator) {
//        WebElement element = DriverManager.getDriver().findElement(locator);
//        if (Boolean.parseBoolean(ConfigFactory.getConfig().highlight())) {
//            JavaScriptUtil.flash(element);
//        }
//        return element;
//    }
//
//    public static WebElement getElement(By locator, int timeOut) {
//        return waitForElementVisible(locator, timeOut);
//    }
//
//    public static List<WebElement> getElements(By locator) {
//        return DriverManager.getDriver().findElements(locator);
//    }
//
//    public static void doSendKeys(By locator, String value) {
//        WebElement element = getElement(locator);
//        element.clear();
//        element.sendKeys(value);
//        //ExtentLogger.logInfo(value + " has been entered");
//    }
//
//    public static void doActionsSendKeys(By locator, String value) {
//        Actions act = new Actions(DriverManager.getDriver());
//        act.sendKeys(getElement(locator), value).build().perform();
//    }
//
//    public static void doClick(By locator) {
//        getElement(locator).click();
//
//    }
//
//    public static void doActionsCick(By locator) {
//        Actions act = new Actions(DriverManager.getDriver());
//        act.click(getElement(locator)).build().perform();
//    }
//
//    public static String doElementGetText(By locator) {
//        return getElement(locator).getText();
//    }
//
//    public static boolean doElementIsDisplayed(By locator) {
//        return getElement(locator).isDisplayed();
//    }
//
//    public static String getElementAttribute(By locator, String attrName) {
//        return getElement(locator).getAttribute(attrName);
//    }
//
//    public static void getElementAttributes(By locator, String attrName) {
//        List<WebElement> eleList = getElements(locator);
//        for (WebElement e : eleList) {
//            String attrVal = e.getAttribute(attrName);
//            System.out.println(attrVal);
//        }
//    }
//
//    public static int getTotalElementsCount(By locator) {
//        int eleCount = getElements(locator).size();
//        System.out.println("total elements for : " + locator + "--->" + eleCount);
//        return eleCount;
//    }
//
//    public static List<String> getElementsTextList(By locator) {
//        List<String> eleTextList = new ArrayList<String>();// size=0
//        List<WebElement> eleList = getElements(locator);
//        for (WebElement e : eleList) {
//            String text = e.getText();
//            eleTextList.add(text);
//        }
//        return eleTextList;
//    }
//
//    // *************************Select based drop down utils****************//
//
//    public static void doSelectDropDownByIndex(By locator, int index) {
//        Select select = new Select(getElement(locator));
//        select.selectByIndex(index);
//    }
//
//    public static void doSelectDropDownByValue(By locator, String value) {
//        Select select = new Select(getElement(locator));
//        select.selectByValue(value);
//    }
//
//    public static void doSelectDropDownByVisibleText(By locator, String text) {
//        Select select = new Select(getElement(locator));
//        select.selectByVisibleText(text);
//    }
//
//    public static List<WebElement> getDropDownOptionsList(By locator) {
//        Select select = new Select(getElement(locator));
//        return select.getOptions();
//    }
//
//    public static List<String> getDropDownOptionsTextList(By locator) {
//        List<WebElement> optionsList = getDropDownOptionsList(locator);
//        List<String> optionsTextList = new ArrayList<String>();
//        for (WebElement e : optionsList) {
//            String text = e.getText();
//            optionsTextList.add(text);
//        }
//        return optionsTextList;
//    }
//
//    public static void selectDropDownValue(By locator, String expValue) {
//        List<WebElement> optionsList = getDropDownOptionsList(locator);
//        for (WebElement e : optionsList) {
//            String text = e.getText();
//            System.out.println(text);
//            if (text.equals(expValue)) {
//                e.click();
//                break;
//            }
//        }
//    }
//
//    public static int getTotalDropDownOptions(By locator) {
//        int optionsCount = getDropDownOptionsList(locator).size();
//        System.out.println("total options ==> " + optionsCount);
//        return optionsCount;
//    }
//
//    public static void doSearch(By suggListLocator, String suggName) {
//        List<WebElement> suggList = getElements(suggListLocator);
//        System.out.println(suggList.size());
//
//        for (WebElement e : suggList) {
//            String text = e.getText();
//            System.out.println(text);
//            if (text.contains(suggName)) {
//                e.click();
//                break;
//            }
//        }
//    }
//
//    // ************************Wait Utils **********************//
//
//    /**
//     * An expectation for checking that an element is present on the DOM of a page.
//     * This does not necessarily mean that the element is visible.
//     *
//     * @param locator
//     * @param timeOut
//     * @return
//     */
//    public static WebElement waitForElementPresence(By locator, int timeOut) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//
//    }
//
//    /**
//     * An expectation for checking that an element is present on the DOM of a page
//     * and visible. Visibility means that the element is not only displayed but also
//     * has a height and width that is greater than 0.
//     *
//     * @param locator
//     * @param timeOut
//     * @return
//     */
//    public static WebElement waitForElementVisible(By locator, int timeOut) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//
//    /**
//     * An expectation for checking that all elements present on the web page that
//     * match the locator are visible. Visibility means that the elements are not
//     * only displayed but also have a height and width that is greater than 0.
//     *
//     * @param locator
//     * @param timeOut
//     * @return
//     */
//    public static List<WebElement> waitForElementsVisible(By locator, int timeOut) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
//    }
//
//    /**
//     * An expectation for checking that there is at least one element present on a
//     * web page.
//     *
//     * @param locator
//     * @param timeOut
//     * @return
//     */
//    public static List<WebElement> waitForElementsPresence(By locator, int timeOut) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
//    }
//
//    /**
//     * @param timeOut
//     * @return
//     */
//    public static Alert waitForAlertPresence(int timeOut) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        return wait.until(ExpectedConditions.alertIsPresent());
//    }
//
//    public static String getAlertText(int timeOut) {
//        return waitForAlertPresence(timeOut).getText();
//    }
//
//    public static void acceptAlert(int timeOut) {
//        waitForAlertPresence(timeOut).accept();
//    }
//
//    public static void dismissAlert(int timeOut) {
//        waitForAlertPresence(timeOut).dismiss();
//    }
//
//    public static void alertSendKeys(int timeOut, String value) {
//        waitForAlertPresence(timeOut).sendKeys(value);
//    }
//
//    public static String waitForTitleContainsAndFetch(int timeOut, String titleFractionValue) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        wait.until(ExpectedConditions.titleContains(titleFractionValue));
//        return DriverManager.getDriver().getTitle();
//    }
//
//    public static String waitForTitleIsAndFetch(int timeOut, String titleValue) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        wait.until(ExpectedConditions.titleIs(titleValue));
//        return DriverManager.getDriver().getTitle();
//    }
//
//    public static String waitForURLContainsAndFetch(int timeOut, String urlFractionValue) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        wait.until(ExpectedConditions.urlContains(urlFractionValue));
//        return DriverManager.getDriver().getCurrentUrl();
//    }
//
//    public static String waitForURLIsAndFetch(int timeOut, String urlValue) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        wait.until(ExpectedConditions.urlToBe(urlValue));
//        return DriverManager.getDriver().getCurrentUrl();
//    }
//
//    public static boolean waitForURLContains(int timeOut, String urlFractionValue) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        return wait.until(ExpectedConditions.urlContains(urlFractionValue));
//
//    }
//
//    public static void waitForFrameAndSwitchToItByIDOrName(int timeOut, String idOrName) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
//    }
//
//    public static void waitForFrameAndSwitchToItByIndex(int timeOut, int frameIndex) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
//    }
//
//    public static void waitForFrameAndSwitchToItByFrameElement(int timeOut, WebElement frameElement) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
//    }
//
//    public static void waitForFrameAndSwitchToItByFrameLoctor(int timeOut, By frameLocator) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
//    }
//
//    /**
//     * An expectation for checking an element is visible and enabled such that you
//     * can click it.
//     *
//     * @param timeOut
//     * @param locator
//     */
//    public static void clickWhenReady(int timeOut, By locator) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//    }
//
//    public static WebElement waitForElementToBeClickable(int timeOut, By locator) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
//        return wait.until(ExpectedConditions.elementToBeClickable(locator));
//    }
//
//    public static void doClickWithActionsAndWait(int timeOut, By locator) {
//        WebElement ele = waitForElementToBeClickable(timeOut, locator);
//        Actions act = new Actions(DriverManager.getDriver());
//        act.click(ele).build().perform();
//    }
//
//    public static WebElement waitForElementPresenceWithFluentWait(int timeOut, int pollingTime, By locator) {
//
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver()).withTimeout(Duration.ofSeconds(timeOut))
//                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
//                .pollingEvery(Duration.ofSeconds(pollingTime)).withMessage("...element is not found on the page....");
//
//        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//
//    }
//
//    public static void waitForAlertWithFluentWait(int timeOut, int pollingTime) {
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver()).withTimeout(Duration.ofSeconds(timeOut))
//                .ignoring(NoAlertPresentException.class).pollingEvery(Duration.ofSeconds(pollingTime))
//                .withMessage("...Alert is not found on the page....");
//        wait.until(ExpectedConditions.alertIsPresent());
//
//    }
//
//}