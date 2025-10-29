package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropdownExample {

    public static void main(String[] args) {
        // Assume WebDriver is already set up
        WebDriver driver = new ChromeDriver();
        driver.get("your_web_page_url");

        // 1. Find the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("country-dropdown"));

        // 2. Instantiate the Select class
        Select dropdown = new Select(dropdownElement);

        // 3. Use one of the selection methods

        // Method 1: Select by visible text
        dropdown.selectByVisibleText("Canada");
        System.out.println("Selected by visible text: Canada");

        // Method 2: Select by value attribute
        dropdown.selectByValue("usa");
        System.out.println("Selected by value: USA");

        // Method 3: Select by index (0-based)
        dropdown.selectByIndex(2);
        System.out.println("Selected by index: Mexico");

        // Close the browser
        driver.quit();
    }
}



//<select name="options">
//  <option value="option1">Option 1</option>
//  <option value="option2">Option 2</option>
//  <option value="option3">Option 3</option>
//  <option value="option4">Option 4</option>
//</select>