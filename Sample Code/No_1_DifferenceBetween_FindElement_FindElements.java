package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class No_1_DifferenceBetween_FindElement_FindElements {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.flipkart.com");

        WebElement element = driver.findElement(By.xpath("//a"));
        System.out.println(element.getAttribute("class"));

        /*
        # findElement() is used find first WebElement matched with given locator.
        # Return type of findElement() is WebElement.
        # If any matching element not found then this method will throw Runtime Exception: NoSuchElementException.
         */

        List<WebElement> list = driver.findElements(By.xpath("//a"));
        System.out.println(list.size());

        /*
        # findElements() is used find all WebElement matched with given locator.
        # Return type of findElements() is List of WebElements.
        # If any matching element not found then this method will never throw any Exception.
        # We can verify  by checking size of list. (If size = 0 then no matching element found)
         */


        driver.quit();


    }
}
