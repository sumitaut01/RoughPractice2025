package selenium.uielements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class R1_Textbox {


    @Test
    public void T1(){

        String url="https://testautomationpractice.blogspot.com/";
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        By name= By.xpath("//input[@id='name']");
        driver.findElement(name).sendKeys("somedata");

        System.out.println(driver.findElement(name).getText());// this wont print typed value
        System.out.println(driver.findElement(name).getAttribute("value"));//somedata
        System.out.println(driver.findElement(name).getDomAttribute("value"));//null
        System.out.println(driver.findElement(name).getDomProperty("value"));//somedata
        driver.quit();
    }
}


/*

This is a very good Selenium question because it highlights the difference between:

Visible text
HTML attributes
DOM properties

Let's analyze each line.

Initial HTML

The textbox on that page looks something like:

<input id="name" type="text">

Initially:

value attribute = not present

and

element.value = ""
After sendKeys()
driver.findElement(name).sendKeys("somedata");

Selenium simulates typing.

The browser updates the DOM property:

element.value = "somedata"

But the original HTML attribute is not modified.

1. getText()
System.out.println(driver.findElement(name).getText());

Output:

""

(or blank)

Why?

getText() returns the visible text between opening and closing tags.

Example:

<div>Hello</div>

returns:

Hello

But an input element is:

<input value="somedata">

There is no inner text.

<input> is a void element.

So:

getText() -> ""
2. getAttribute("value")
System.out.println(driver.findElement(name).getAttribute("value"));

Output:

somedata
Why?

Selenium's getAttribute() is special.

It first tries:

element.value

(the property)

and if not found, it checks the HTML attribute.

Therefore:

getAttribute("value")

returns the current textbox value.

3. getDomAttribute("value")
System.out.println(driver.findElement(name).getDomAttribute("value"));

Output:

null
Why?

getDomAttribute() looks only at the actual HTML attribute.

Originally:

<input id="name">

No value attribute exists.

After typing:

element.value = "somedata"

The browser does NOT automatically change the HTML to:

<input value="somedata">

So:

getDomAttribute("value")

returns:

null

because no value attribute exists in the markup.

4. getDomProperty("value")
System.out.println(driver.findElement(name).getDomProperty("value"));

Output:

somedata
Why?

This reads the live DOM property:

element.value

After sendKeys:

element.value = "somedata"

So:

getDomProperty("value")

returns:

somedata
Quick Summary
Method	Reads	Output
getText()	Visible text between tags	""
getAttribute("value")	Property first, then attribute	"somedata"
getDomAttribute("value")	HTML attribute only	null
getDomProperty("value")	Live DOM property	"somedata"
Simple JavaScript analogy

Suppose a page contains:

<input id="name">

Then:

let e = document.getElementById("name");

e.value = "somedata";

Now:

e.getAttribute("value")    // null
e.value                    // "somedata"

This is exactly why:

getDomAttribute("value") -> null
getDomProperty("value") -> somedata

For Selenium interviews, a common rule is:

For textboxes, use getAttribute("value") or getDomProperty("value") to read the entered text. getText() will not work because input elements do not contain inner text.
 */