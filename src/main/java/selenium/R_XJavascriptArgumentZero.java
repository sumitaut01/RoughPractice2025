package selenium;

//What is arguments[0] in JavaScriptExecutor?
//In JavaScript, the arguments object is an array-like object available inside functions
// that contains the values of the arguments passed to that function.
//
//✅ In Selenium JavaScriptExecutor:
//js.executeScript("arguments[0].click();", someWebElement);
//
//
//Here, arguments[0] refers to the first object passed from Java to the JavaScript snippet.
//In this case, it's the someWebElement.

//🔹 Behind the scenes:

//This line:
//js.executeScript("arguments[0].click();", element);
//
//
//...translates internally in JavaScript to:
//
//function() {
//    arguments[0].click(); // element is at index 0
//}
//
//
//If you pass multiple arguments from Java:
//js.executeScript("arguments[0].value=arguments[1];", inputElement, "Hello");
//
//Then:

//arguments[0] → the WebElement (e.g., input field)
//arguments[1] → the value "Hello"
//
//🔹 Analogy
//Think of this as:
//
//function myFunc(arg0, arg1, arg2) {
//    // You can refer to them as:
//    arguments[0], arguments[1], ...
//}

//In Selenium:
//WebDriver passes your WebElement(s) and other values as arguments[0], arguments[1], etc.
//
//JavaScript accesses those in the order you passed them.
//
//✅ Real Example:
//WebElement input = driver.findElement(By.id("name"));
//js.executeScript("arguments[0].value = arguments[1];", input, "Sumit");
//
//JS in browser becomes:
//arguments[0].value = arguments[1];
//// which means: input.value = "Sumit"
public class R_XJavascriptArgumentZero {
}
