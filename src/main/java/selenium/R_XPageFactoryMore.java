package selenium;

public class R_XPageFactoryMore {
}

//explain all these findby, findabys,findall,finddistinct in selenium page factory
//Excellent — that screenshot is from IntelliJ showing all the Selenium Page Factory annotations that can be used for locating web elements (@FindBy, @FindBys, @FindAll) — plus some unrelated ones (@FindDistinct from Checker Framework and PageFactoryFinder).
//
//Let’s break down each of them clearly and with examples 👇
//
//🔹 1. @FindBy
//
//This is the most common Selenium PageFactory annotation.
//
//It is used to locate a single web element using one locating strategy (like id, name, xpath, etc.).
//
//Example:
//@FindBy(id = "username")
//private WebElement usernameInput;
//
//@FindBy(xpath = "//button[@type='submit']")
//private WebElement submitButton;
//
//
//Here Selenium knows:
//
//usernameInput is found by id="username".
//
//submitButton is found by the given xpath.
//
//You then initialize it using:
//
//PageFactory.initElements(driver, this);
//
//
//✅ Use when: you have one locator for one element.
//
//🔹 2. @FindBys
//
//This is used when you want to apply multiple locators in an AND condition.
//In other words, each locator is applied sequentially — the second one searches inside the result of the first one.
//
//Example:
//@FindBys({
//    @FindBy(className = "form-container"),
//    @FindBy(tagName = "input")
//})
//private List<WebElement> inputFields;
//
//
//👉 Meaning:
//
//Find the element with class="form-container".
//
//Then, inside it, find all <input> elements.
//
//So both locators must match in sequence.
//If either one fails → element not found.
//
//✅ Use when: you want an AND condition — nested or scoped searching.
//
//🔹 3. @FindAll
//
//This is used for an OR condition — i.e., the element can be found by any of the given locators.
//
//Example:
//@FindAll({
//    @FindBy(id = "loginBtn"),
//    @FindBy(xpath = "//button[text()='Login']")
//})
//private WebElement loginButton;
//
//
//👉 Meaning:
//
//Find an element either with id="loginBtn" OR with the XPath matching the text “Login”.
//
//So if either locator works, Selenium will use that element.
//
//✅ Use when: the same element may appear under different locators in different contexts (e.g., multiple versions of a page).
//
//🔹 4. @FindDistinct
//
//⚠️ Not part of Selenium!
//This comes from a different library — org.checkerframework.checker.interning.qual.FindDistinct.
//
//It’s related to the Checker Framework (used for static analysis of Java code).
//
//It has nothing to do with Selenium or web element locating.
//
//You can safely ignore it in the context of Page Factory.
//
//🔹 5. PageFactoryFinder
//
//Also not an annotation you use directly.
//It’s an internal helper annotation that Selenium uses to link locator annotations (@FindBy, @FindBys, @FindAll) with their corresponding By builder implementations.
//
//So you’ll see:
//
//@PageFactoryFinder(FindBy.FindByBuilder.class)
//
//
//inside Selenium’s source code for @FindBy.
//
//You don’t use PageFactoryFinder in your test code — it’s for Selenium’s internal mechanism to map annotations to By locators.
//
//🔹 Summary Table
//Annotation	Package	Purpose	Logical Behavior	Example
//@FindBy	org.openqa.selenium.support	Locate one element by one strategy	—	@FindBy(id="username")
//@FindBys	org.openqa.selenium.support	Combine multiple locators (AND)	All must match	@FindBys({@FindBy(class="a"), @FindBy(tag="b")})
//@FindAll	org.openqa.selenium.support	Try multiple locators (OR)	Any match works	@FindAll({@FindBy(id="x"), @FindBy(name="y")})
//@FindDistinct	org.checkerframework.checker.interning.qual	Checker Framework annotation (not Selenium)	❌ Unrelated	Ignore for Selenium
//@PageFactoryFinder	org.openqa.selenium.support	Internal Selenium mapping annotation	Internal use only	Don’t use directly
//
//Would you like me to show you how Selenium internally resolves these annotations (e.g., how PageFactoryFinder uses reflection to turn @FindBy into a By locator)?
