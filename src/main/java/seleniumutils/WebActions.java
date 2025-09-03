//package reporters;
//
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.time.DateTimeException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Random;
//
//import static com.google.common.base.Throwables.getStackTraceAsString;
//
//public class WebActions  {
//
//
//    private  WebActions() {
//    }
//
//    public static boolean isEnabled(By locator) {
//        boolean flag ;//= false;
//
//        try {
//            WebElement element =  findElement(locator);
//            flag = element.isEnabled();
//        } catch (Exception var4) {
//            flag = false;
//        }
//
//        return flag;
//    }
//
//    public static boolean isDisplayed(By locator) {
//        boolean flag ;//= false;
//
//        try {
//            flag = DriverManager.getDriver().findElement(locator).isDisplayed();
//        } catch (Exception var4) {
//            flag = false;
//        }
//
//        return flag;
//    }
//
//    public static WebElement findElement(By locator) {
//        WebElement element = null;
//        int retry = 0;
//
//        try {
//            if (ConfigFactory.getConfig().retry()>0) {
//                retry = ConfigFactory.getConfig().retry();
//            } else {
//                retry = 0;
//            }
//
//            do {
//                try {
//                    --retry;
//                    element = DriverManager.getDriver().findElement(locator);
//                    if (Boolean.parseBoolean(ConfigFactory.getConfig().highlight())) {
//                        JavaScriptUtil.flash(element);
//                    }
//                } catch (Exception var5) {
//                    if (retry <= 0) {
//                        throw var5;
//                    }
//                }
//            } while(retry > 0 && element == null);
//        } catch (Exception var6) {
//            var6.printStackTrace();
//            Assert.fail("Exception occurred while trying to find element using locator:" + locator + ", with RetryCount:" + retry);
//        }
//        return element;
//    }
//
//    public static List<WebElement> findElements(By locator) {
//        return DriverManager.getDriver().findElements(locator);
//    }
//
//    public static void navigateToURL(String url) {
//        try {
//
//            DriverManager.getDriver().get(url);
//
//        } catch (Exception var3) {
//
//            var3.printStackTrace();
//            Assert.fail("Exception occurred while navigating to URL ::" + url +getStackTraceAsString(var3));
//        }
//
//    }
//
//
//    public static void refreshPage(){
//
//        try {
//            DriverManager.getDriver().navigate().refresh();
//        }
//        catch(Exception var){
//            var.printStackTrace();
//            Assert.fail("Exception occurred while refreshing the page. "+getStackTraceAsString(var));
//
//        }
//
//
//    }
//
//    public static String getPageTitle() {
//        return DriverManager.getDriver().getTitle();
//    }
//
//    public static void sendKeys(By locator, String value) {
//
//        if(String.valueOf(value).trim().equalsIgnoreCase("<SKIP>")) return;//experimenting
//        try {
//            WebElement element =  findElement(locator);
//            element.sendKeys(value);
//
//        } catch (Exception var5) {
//            var5.printStackTrace();
//            Assert.fail("Exception while entering text to: " + locator+" "+getStackTraceAsString(var5));
//        }
//
//    }
//
//    public static String getText(By locator) {
//        String textValue = null;
//
//        try {
//            WebElement element =  findElement(locator);
//            textValue = element.getText();
//
//        } catch (Exception var5) {
//
//            var5.printStackTrace();
//            Assert.fail("Error while fetching text of element " + locator+" "+getStackTraceAsString(var5));
//        }
//
//        return textValue;
//    }
//
//    public static void PressKey(By locator, Keys key) {
//        try {
//            WebElement element = findElement(locator);
//             getActionsObj().sendKeys(element, new CharSequence[]{key}).build().perform();
//
//        } catch (Exception var5) {
//            var5.printStackTrace();
//            Assert.fail("Error while perfoming Press Key - " + key + " operation at element :: " + locator+" "+getStackTraceAsString(var5));
//        }
//
//    }
//
//    public static void PressKey(Keys key) {
//        try {
//             getActionsObj().sendKeys(new CharSequence[]{key}).build().perform();
//
//        } catch (Exception var3) {
//
//            var3.printStackTrace();
//            Assert.fail("Error while performing Press Key :: " + key + " operation "+ " "+getStackTraceAsString(var3));
//        }
//
//    }
//
//    public static void simulateHumanSendkeys(By locator, String text, int delayInMillis) {
//        try {
//            WebElement element =  findElement(locator);
//            char[] var5 = text.toCharArray();
//            int var6 = var5.length;
//
//            for(int var7 = 0; var7 < var6; ++var7) {
//                char sub = var5[var7];
//                Thread.sleep(delayInMillis);
//                element.sendKeys(String.valueOf(sub));
//            }
//
//
//        } catch (Exception var9) {
//            var9.printStackTrace();
//            Assert.fail("Exception while entering text into: " + locator+ " "+getStackTraceAsString(var9));
//        }
//
//    }
//
//    public static Actions getActionsObj() {
//        Actions actions = null;
//
//        try {
//            actions = new Actions(DriverManager.getDriver());
//        } catch (Exception var3) {
//
//            var3.printStackTrace();
//            Assert.fail("Exception while geting Actions class Object."+ " "+getStackTraceAsString(var3));
//        }
//
//        return actions;
//    }
//
//    public static void click(By locator) {
//        try {
//            WebElement element =  findElement(locator);
//            element.click();
//
//        } catch (Exception var4) {
//
//            var4.printStackTrace();
//            Assert.fail("Exception in clicking element: " + locator + " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static void doubleClick(By locator) {
//        try {
//            WebElement element =  findElement(locator);
//            WebDriverWait wait =  getWebDriverWait();
//            wait.until(ExpectedConditions.elementToBeClickable(element));
//             getActionsObj().doubleClick(element).build().perform();
//
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Exception in double clicking element: " + locator+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//     public static WebDriverWait getWebDriverWait() {
//        WebDriverWait wait = null;
//
//        try {
//            wait = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.EXPLICITWAITTIMEOUT);
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Assert.fail("Exception while getting WebDriverWait class object."+ " "+getStackTraceAsString(var3));
//        }
//
//        return wait;
//    }
//
//    public static void clear(By locator) {
//        try {
//            WebElement element =  findElement(locator);
//            element.clear();
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Exception while clearing text: " + locator+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static String getAttributeValue(By locator, String attributeName) {
//        String value = null;
//
//        try {
//            WebElement element =  findElement(locator);
//            value = element.getAttribute(attributeName);
//        } catch (Exception var6) {
//            Assert.fail("Exception occurred while trying to get attribute: " + attributeName + " value from element:" + locator+ " "+getStackTraceAsString(var6));
//            var6.printStackTrace();
//        }
//
//        return value;
//    }
//
//    public static void scrollToElement(By locator) {
//        try {
//             getActionsObj().moveToElement(DriverManager.getDriver().findElement(locator));
//             getActionsObj().perform();
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Assert.fail("Error scrolling to desired element " + locator+ " "+getStackTraceAsString(var3));
//        }
//
//    }
//
//    public static void selectByVisibleText(By locator, String text) {
//        try {
//             scrollToElement(locator);
//            Select sel = new Select(DriverManager.getDriver().findElement(locator));
//            sel.selectByVisibleText(text);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Error in selecting from dropdown " + locator+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static boolean isElementPresent(By locator) {
//        boolean flag = false;
//
//        try {
//            return DriverManager.getDriver().findElement(locator).isDisplayed();
//        } catch (NoSuchElementException var4) {
//            Assert.fail("The element " + locator + " is not displayed yet..."+ " "+getStackTraceAsString(var4));
//            return flag;
//        }
//    }
//
//    public static int getRowSize(By locator) {
//       // int rowsCount = false;
//
//
//        try {
//            List<WebElement> rows_table = DriverManager.getDriver().findElements(By.tagName("tr"));
//            int rowsCount = rows_table.size();
//            return rowsCount;
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Excpetion in finding table: " + locator+ " "+getStackTraceAsString(var4));
//            return 0;
//        }
//    }
//
//    public List<WebElement> getTablerows(By locator) {
//        List<WebElement> tableRows = null;
//
//        try {
//            tableRows = DriverManager.getDriver().findElements(By.tagName("tr"));
//            return tableRows;
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Exception in finding table: " + locator+ " "+getStackTraceAsString(var4));
//            return null;
//        }
//    }
//
//    public static List<WebElement> getTableRowsWebElements(By locator) {
//        List<WebElement> tableRows = null;
//
//        try {
//            tableRows = DriverManager.getDriver().findElements(locator);
//            return tableRows;
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Exception in finding table: " + locator+ " "+getStackTraceAsString(var4));
//            return null;
//        }
//    }
//
//    public static void selectByValue(By locator, String value) {
//        try {
//             scrollToElement(locator);
//            Select sel = new Select(DriverManager.getDriver().findElement(locator));
//
//
//            sel.selectByValue(value);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Error in selecting from dropdown " + locator+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static void selectByIndex(By locator, int value) {
//        try {
//             scrollToElement(locator);
//            Select sel = new Select(DriverManager.getDriver().findElement(locator));
//            sel.selectByIndex(value);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Error in selecting from dropdown " + locator+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static void selectByRandoxIndex(By locator) {
//        try {
//             scrollToElement(locator);
//            Select sel = new Select(DriverManager.getDriver().findElement(locator));
//            //int max = false;
//            int min = 2;
//            int max = sel.getOptions().size();
//            if (max < min) {
//                Assert.fail(locator.toString() + " Drop down is empty");
//            }
//
//            Random r = new Random();
//            int index = r.nextInt(max - min) + min;
//            sel.selectByIndex(index);
//        } catch (Exception var7) {
//            var7.printStackTrace();
//            Assert.fail("Error in selecting from dropdown " + locator+ " "+getStackTraceAsString(var7));
//        }
//
//    }
//
//    public static String getSelectedOption(By locator) {
//        try {
//             scrollToElement(locator);
//            Select sel = new Select(DriverManager.getDriver().findElement(locator));
//            return sel.getFirstSelectedOption().getText().trim();
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Assert.fail("Error in selecting from dropdown " + locator +getStackTraceAsString(var3));
//            return null;
//        }
//    }
//
//    public List<WebElement> getAllOption(By locator) {
//        try {
//             scrollToElement(locator);
//            Select sel = new Select(DriverManager.getDriver().findElement(locator));
//            return sel.getOptions();
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Assert.fail("Error in selecting from dropdown " + locator+ " "+getStackTraceAsString(var3));
//            return null;
//        }
//    }
//
//    public static void switchToActiveWindow() {
//        DriverManager.getDriver().switchTo().activeElement();
//    }
//
//    public static void switctoIFrame(By locator) {
//        try {
//            DriverManager.getDriver().switchTo().frame(DriverManager.getDriver().findElement(locator));
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Assert.fail("Error fetching text of element " + locator+ " "+getStackTraceAsString(var3));
//        }
//
//    }
//
//    public static void switchToDefaultContect() {
//        try {
//            DriverManager.getDriver().switchTo().defaultContent();
//        } catch (Exception var2) {
//            var2.printStackTrace();
//            Assert.fail("Error switching to the default content."+ " "+getStackTraceAsString(var2));
//        }
//
//    }
//
//    public static void selectCustomDateInPicker(By locator, String date) {
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/dd/yyyy");
//            LocalDate localDate = LocalDate.parse(date, formatter);
//            String year = ("" + localDate.getYear()).trim();
//            String month = ("" + localDate.getMonthValue()).trim();
//            String day = ("" + localDate.getDayOfMonth()).trim();
//            By lst_month = By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]");
//            By lst_year = By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]");
//            By lnk_day = By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[text()='" + day + "']");
//            System.out.println("Year -->" + year + " Month--->" + month + " Day--->" + day);
//             click(locator);
//             selectByVisibleText(lst_month, month);
//             selectByVisibleText(lst_year, year);
//             click(lnk_day);
//        } catch (DateTimeException var11) {
//            var11.printStackTrace();
//            Assert.fail("Error in parsing the date" + date);
//        } catch (Exception var12) {
//            var12.printStackTrace();
//            Assert.fail("Error when selecting date" + locator+ " "+getStackTraceAsString(var12));
//        }
//
//    }
//
//    public static void selectCurrentDateInPicker(By locator) {
//        By selectedDate = By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(@class, 'highlight')]");
//
//        try {
//             click(locator);
//             click(selectedDate);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Error when selecting current date " + DriverManager.getDriver().findElement(selectedDate).getText() + " from angular date picker" + locator+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//
//    public static boolean urlIsAccessible(String url) {
//        boolean flag = false;
//
//        try {
//            HttpURLConnection connection = (HttpURLConnection)(new URL(url)).openConnection();
//            connection.setConnectTimeout(5000);
//            flag = connection.getResponseCode() == 200;
//        } catch (Exception var4) {
//            flag = false;
//        }
//
//        return flag;
//    }
//
//    public static void mouseHover(By locator) {
//        try {
//
//            WebElement element =  findElement(locator);
//             getActionsObj().moveToElement(element).build().perform();
//
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Assert.fail("Exception occured while trying to hover over element : " + locator.toString()+ " "+getStackTraceAsString(var3));
//        }
//
//    }
//
//    public static boolean isSelected(By locator) {
//        boolean flag = false;
//
//        try {
//            WebElement element =  findElement(locator);
//            flag = element.isSelected();
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("\"Exception occured while trying to check whether or not the element '\" + locator.toString() + \"' is selected.\");+ \" \"+getStackTraceAsString(var3)");
//        }
//
//        return flag;
//    }
//
//    public static void selectCheckbox(By locator) {
//        try {
//            WebElement element =  findElement(locator);
//            if (!element.isSelected()) {
//                element.click();
//            }
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Assert.fail("Error while using selectCheckbox method  for locator "+locator.toString()+ " "+getStackTraceAsString(var3));
//          //  ExceptionHandler.handle(var3, "Exception occured while trying to select checkbox ::" + locator.toString());
//        }
//
//    }
//
//    public static void unSelectCheckbox(By locator) {
//        try {
//            WebElement element =  findElement(locator);
//            if (element.isSelected()) {
//                element.click();
//            }
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            Assert.fail("Error while using unSelectCheckbox method  for locator "+locator.toString()+ " "+getStackTraceAsString(var3));
//            //ExceptionHandler.handle(var3, "Exception occured while trying to un-select checkbox ::" + locator.toString());
//        }
//
//    }
//
//    public static void clearAllCookies() {
//        try {
//            DriverManager.getDriver().manage().deleteAllCookies();
//        } catch (Exception var2) {
//            var2.printStackTrace();
//           Assert.fail("Exception occured while trying to clear browser cookies. "+ " "+getStackTraceAsString(var2));
//        }
//
//    }
//
//    public static void executeJavaScript(String script, Object... args) {
//        try {
//            ((JavascriptExecutor)DriverManager.getDriver()).executeScript(script, args);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Assert.fail("Failed to execute jacascript. "+ " "+getStackTraceAsString(var4));
//        }
//
//    }
//}
