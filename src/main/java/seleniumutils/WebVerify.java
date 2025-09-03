//package reporters;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//
//public final class WebVerify  {
//
//    private WebVerify() {
//    }
//
//    public static void elementIsPresent(By by) {
//        WebElement element =  WebActions.findElement(by);
//        Assert.assertTrue(element != null, "Validation Failed : Expected Element: " + by + ", is not present in the DOM.");
//    }
//
//    public static void elementIsDisplayed(By by) {
//        Assert.assertTrue( WebActions.isDisplayed(by), "Validation Failed : Element is NOT Displayed : " + by);
//    }
//
//    public static void elementIsEnabled(By by) {
//        Assert.assertTrue( WebActions.isEnabled(by), "Validation Failed : Element is NOT Enabled : " + by);
//    }
//
//    public static void elementIsClickable(By by) {
//        Assert.assertTrue( WebActions.isEnabled(by) &&  WebActions.isDisplayed(by), "Validation Failed : Element is NOT Clickable : " + by);
//    }
//
//    public static void elementHasAttribute(By by, String attributeName) {
//        String value =  WebActions.getAttributeValue(by, attributeName);
//        if (value == null) {
//            Assert.fail("Validation Failed :" + by + " does not contains the specified attribute: " + attributeName);
//        }
//
//    }
//
//    public static void  attributeHasValue(By by, String attribute, String expectedValue) {
//        String actualValue = DriverManager.getDriver().findElement(by).getAttribute(attribute);
//        Assert.assertTrue(actualValue.contains(expectedValue), "Validation Failed : Attribute Has No Value : " + by);
//    }
//
//    public static void textboxIsEmpty(By by) {
//        String textBoxValue =  WebActions.getAttributeValue(by, "value");
//        if (!textBoxValue.trim().equals("")) {
//            String failureMsg = "Validation Failed : The text-box '" + by + "' is NOT Empty; it contains : " + textBoxValue;
//             Assert.fail(failureMsg);
//        }
//
//    }
//
//    public static void elementContainsText(By by, String text) {
//        String uiText =  WebActions.getText(by);
//        if (!uiText.contains(text)) {
//            String failureMsg = "Validation Failed : Element text '" + uiText + "' does NOT contain expected '" + text + "' : " + by;
//             Assert.fail(failureMsg);
//        }
//
//    }
//
//    public static void elementDoesNotContainsText(By by, String text) {
//        String uiText =  WebActions.getText(by);
//        if (uiText.contains(text)) {
//            String failureMsg = "Validation Failed : Element(" + by + ") contains unexpected text '" + text + ", Actual text " + uiText;
//             Assert.fail(failureMsg);
//        }
//
//    }
//
//    public static void exactTextInElementIs(By by, String text) {
//        String uiText =  WebActions.getText(by);
//        if (!uiText.equals(text)) {
//            String failureMsg = "Validation Failed : Element text '" + uiText + "' does NOT match expected '" + text + "' : " + by;
//             Assert.fail(failureMsg);
//        }
//
//    }
//
//    public static void exactTextInElementIsNot(By by, String text) {
//        String uiText =  WebActions.getText(by);
//        if (uiText.equals(text)) {
//            String failureMsg = "Validation Failed : Element text '" + uiText + "' is SAME as '" + text + "' : " + by;
//             Assert.fail(failureMsg);
//        }
//
//    }
//
//    public static void pageTitle(String pageTitle) {
//        String actualPageTitle =  WebActions.getPageTitle();
//        Assert.assertEquals(pageTitle, actualPageTitle);
//    }
//
//    public static void partialPageTitle(String partialPageTitle) {
//        String actualPageTitle =  WebActions.getPageTitle();
//        Assert.assertTrue(actualPageTitle.contains(partialPageTitle));
//    }
//}