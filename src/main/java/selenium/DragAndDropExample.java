package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class DragAndDropExample {

    public static void main(String[] args) {
        // Assume WebDriver is already set up
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        // The drag-and-drop element is inside an iframe, so switch to it
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Find the source and target elements
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Instantiate the Actions class
        Actions actions = new Actions(driver);

        // Perform the drag-and-drop operation
        actions.dragAndDrop(source, target).perform();

        System.out.println("Drag and drop successful.");
        
        // Close the browser
        driver.quit();
    }
}